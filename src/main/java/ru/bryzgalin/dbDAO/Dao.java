package ru.bryzgalin.dbDAO;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(Connection connection, long id);
    List<T> getAll(Connection connection);
    void create(Connection connection, T entity);
    void update(Connection connection, T entity);
    void delete(Connection connection, T entity);
}