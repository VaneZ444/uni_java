package ru.bryzgalin.dbDAO.advanced;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class DaoFinders extends BaseDao {
    public DaoFind(Connection connection, Map<Class<?>, Function<String, ?>> converters) {
        super(connection, converters);
    }

    @GeneratedMethod
    public <T> List<T> findAllByName(Class<T> clz, String name) {
        return invokeGeneratedMethod(clz, "findAllByName", name);
    }
}