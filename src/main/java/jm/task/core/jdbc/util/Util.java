package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final  String PASSWORD = "root1234";
    public static Connection getConnection() {
        Connection connection = null;

        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение с БД установлено!");
            }
            if (connection.isClosed()) {
                System.out.println("Соединнение с БД закрыто!");
            }
        } catch (SQLException e) {
            System.err.println("Неудалос загрузить класс драйвера!");
        }
        return connection;
    }
}
