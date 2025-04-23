package ru.bryzgalin.dbDAO;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
public class DaoFind {
    private final Connection connection;
    private final Map<Class<?>, Function> converters;

    public DaoFind(Connection connection, Map<Class<?>, Function> converters) {
        this.connection = connection;
        this.converters = converters;
    }

    @SneakyThrows
    public <T> List<T> findAll(Class<T> clz){
        List<T> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM ?")){
            String table = clz.getSimpleName();
            statement.setString(1,table);
            ResultSet res = statement.executeQuery();
            while (res.next()){
                T newObj = clz.getDeclaredConstructor().newInstance();
                for (Field declaredField : clz.getDeclaredFields()){
                    declaredField.setAccessible(true);
                    String column;
                    if(declaredField.isAnnotationPresent(Column.class) || declaredField.getAnnotation(Column.class).value() != null){
                        column = declaredField.getAnnotation(Column.class).value();
                    } else {                        column = declaredField.getName();
                    }
                    Object columnRes = converters.get(declaredField.getType()).apply(res.getString(column));
                    declaredField.set(newObj, columnRes);
                }
                result.add(newObj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
//TODO : setters, use only necessary fields, набор конвертеров, custom exceptions,
//TODO : автогенерация таблиц (?), нейминг - переход на аннотации, кастомные методы
//TODO HW : (допустим findAllByName(Class, string), но добавление одной этой строкой (как???))