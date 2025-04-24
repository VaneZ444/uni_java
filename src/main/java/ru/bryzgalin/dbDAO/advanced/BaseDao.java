package ru.bryzgalin.dbDAO.advanced;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import ru.bryzgalin.dbDAO.advanced.GeneratedMethod;
import ru.bryzgalin.dbDAO.shared.Column;
import ru.bryzgalin.dbDAO.shared.DaoException;
import ru.bryzgalin.dbDAO.shared.FieldSetException;
import ru.bryzgalin.dbDAO.shared.QueryBuildException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
@Component
public class BaseDao {
    private final Connection connection;
    private final Map<Class<?>, Function<String, ?>> converters;

    public BaseDao(Connection connection, Map<Class<?>, Function<String, ?>> converters) {
        this.connection = connection;
        this.converters = converters;
    }

    @SneakyThrows
    public <T> List<T> findAll(Class<T> clz) {
        List<T> result = new ArrayList<>();
        String table = clz.getSimpleName();
        String query;
        try {
            query = buildQuery(clz, table);
        } catch (Exception e) {
            throw new QueryBuildException("Failed to build query for class " + clz.getName(), e);
        }

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                T newObj = clz.getDeclaredConstructor().newInstance();
                for (Field declaredField : clz.getDeclaredFields()) {
                    if (declaredField.isAnnotationPresent(Column.class)) {
                        String columnName = declaredField.getAnnotation(Column.class).value();
                        if (columnName.isEmpty()) {
                            columnName = declaredField.getName();
                        }
                        Object columnRes = converters.get(declaredField.getType()).apply(res.getString(columnName));
                        try {
                            setFieldValue(newObj, declaredField, columnRes);
                        } catch (Exception e) {
                            throw new FieldSetException("Failed to set value for field " + declaredField.getName(), e);
                        }
                    }
                }
                result.add(newObj);
            }
        } catch (SQLException e) {
            throw new DaoException("SQL exception occurred", e);
        }
        return result;
    }

    private <T> String buildQuery(Class<T> clz, String table) {
        List<String> columns = new ArrayList<>();
        for (Field field : clz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Column.class)) {
                String columnName = field.getAnnotation(Column.class).value();
                if (columnName.isEmpty()) {
                    columnName = field.getName();
                }
                if (columnName.isEmpty()) {
                    throw new QueryBuildException("Column name is empty for field " + field.getName());
                }
                columns.add(columnName);
            }
        }
        if (columns.isEmpty()) {
            throw new QueryBuildException("No columns found for class " + clz.getName());
        }
        return "SELECT " + String.join(", ", columns) + " FROM " + table;
    }

    private <T> void setFieldValue(T obj, Field field, Object value) throws Exception {
        String setterName = "set" + capitalize(field.getName());
        Method setter = obj.getClass().getMethod(setterName, field.getType());
        setter.invoke(obj, value);
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    @SneakyThrows
    public <T> List<T> invokeGeneratedMethod(Class<T> clz, String methodName, Object... args) {
        Method method = this.getClass().getMethod(methodName, Class.class, args.getClass());
        if (method.isAnnotationPresent(GeneratedMethod.class)) {
            GeneratedMethod annotation = method.getAnnotation(GeneratedMethod.class);
            String query = annotation.query();
            if (query.isEmpty()) {
                query = buildDynamicQuery(clz, methodName, args);
            }
            return executeQuery(clz, query, args);
        }
        throw new DaoException("Method " + methodName + " is not a generated method");
    }

    private <T> String buildDynamicQuery(Class<T> clz, String methodName, Object... args) {
        String table = clz.getSimpleName().toLowerCase();
        String condition = "";
        if (methodName.contains("ByName")) {
            condition = " WHERE name = ?";
        }
        return "SELECT * FROM " + table + condition;
    }

    private <T> List<T> executeQuery(Class<T> clz, String query, Object... args) throws SQLException {
        List<T> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < args.length; i++) {
                statement.setObject(i + 1, args[i]);
            }
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                T newObj = clz.getDeclaredConstructor().newInstance();
                for (Field declaredField : clz.getDeclaredFields()) {
                    if (declaredField.isAnnotationPresent(Column.class)) {
                        String columnName = declaredField.getAnnotation(Column.class).value();
                        if (columnName.isEmpty()) {
                            columnName = declaredField.getName();
                        }
                        Object columnRes = converters.get(declaredField.getType()).apply(res.getString(columnName));
                        try {
                            setFieldValue(newObj, declaredField, columnRes);
                        } catch (Exception e) {
                            throw new FieldSetException("Failed to set value for field " + declaredField.getName(), e);
                        }
                    }
                }
                result.add(newObj);
            }
        } catch (Exception e) {
            throw new DaoException("Failed to execute query",e);
        }
        return result;
    }
}
