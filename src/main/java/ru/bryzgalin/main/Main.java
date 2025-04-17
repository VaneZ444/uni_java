package ru.bryzgalin.main;

import ru.bryzgalin.dbDAO.UserDao;
import ru.bryzgalin.dbDAO.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:h2:mem:test;";
        try (Connection connection = DriverManager.getConnection(url, "sa", "")) {
            initDatabase(connection);
            UserDao userDao = new UserDao();
            operationTests(connection, userDao);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void initDatabase(Connection connection) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS users ("
                    + "id BIGINT AUTO_INCREMENT PRIMARY KEY,"
                    + "name VARCHAR(100) NOT NULL,"
                    + "email VARCHAR(100)"
                    + ")");

            stmt.executeUpdate("INSERT INTO users (name, email) VALUES "
                    + "('John', 'john@example.com'), "
                    + "('Jane', 'jane@example.com')");
        }
    }

    private static void operationTests(Connection connection, UserDao userDao) throws SQLException {
        User newUser = new User();
        newUser.setName("Greg");
        userDao.create(connection, newUser);
        System.out.println("added  " + newUser);

        List<User> users = userDao.getAll(connection);
        System.out.println(users);

        User userToUpdate = users.getFirst();
        userToUpdate.setName("Bob");
        userDao.update(connection, userToUpdate);
        System.out.println("updated  " + userDao.get(connection, userToUpdate.getId()));

        userDao.delete(connection, userToUpdate);
        System.out.println("after delete  " + userDao.getAll(connection));
    }
}