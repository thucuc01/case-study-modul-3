package dao;

import java.sql.*;

public class DBConnection {
    private Connection conn;

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/shop_db";
    private static final String USER = "root";
    private static final String PASSWORD = "KhoaiTay@2019";

    public DBConnection() {
        try {
            // 1. Dang ky Driver
            Class.forName(JDBC_DRIVER);
            // 2. Mo ket noi
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected successfully.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Could not connect: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public ResultSet getData(String sql) {
        ResultSet rs = null;
        try {
//            ResultSet.TYPE_FORWARD_ONLY: default, con tro chi di xuong
//            ResultSet.TYPE_SCROLL_SENSITIVE: con tro quay len, khong co threadSafe
//            ResultSet.TYPE_SCROLL_INSENSITIVE: con tro quay len, co threadSafe, chuan 4, bat buoc
//            ResultSet.CONCUR_READ_ONLY: default, khong sua duoc ResultSet
//            ResultSet.CONCUR_UPDATABLE: sua duoc ResultSet
            Statement statement = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }
}
