package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/shop_db";
    private static final String USER = "root";
    private static final String PASSWORD = "KhoaiTay@2019";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // 1. Dang ky Driver
            Class.forName(JDBC_DRIVER);
            // 2. Mo ket noi
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected successfully.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Could not connect: " + e.getMessage());
        }
        return conn;
    }
}
