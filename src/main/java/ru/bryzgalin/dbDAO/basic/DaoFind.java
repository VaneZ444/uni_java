package ru.bryzgalin.dbDAO.basic;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import ru.bryzgalin.dbDAO.shared.Column;
import ru.bryzgalin.dbDAO.shared.FieldSetException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
public class DaoFind {
    private final Connection connection;
    private final Map<Class<?>, Function<String, ?>> converters;

    public DaoFind(Connection connection, Map<Class<?>, Function<String, ?>> converters) {
        this.connection = connection;
        this.converters = converters;
    }

    @SneakyThrows
    public <T> List<T> findAll(Class<T> clz) {
        List<T> result = new ArrayList<>();
        String table = clz.getSimpleName();
        String query = buildQuery(clz, table);

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                T newObj = clz.getDeclaredConstructor().newInstance();
                for (Field declaredField : clz.getDeclaredFields()) {
                    if (declaredField.isAnnotationPresent(Column.class)) {
                        String columnName = declaredField.getAnnotation(Column.class).value();
                        if (columnName.isEmpty()) columnName = declaredField.getName();
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
            throw new RuntimeException(e);
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
                columns.add(columnName);
            }
        }
        return "SELECT " + String.join(", ", columns) + " FROM " + table;
    }

    private <T> void setFieldValue(T obj, Field field, Object value) throws Exception {
        String setterName = "set" + capitalize(field.getName());
        Method setter = obj.getClass().getMethod(setterName, field.getType());
        setter.invoke(obj, value);
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
