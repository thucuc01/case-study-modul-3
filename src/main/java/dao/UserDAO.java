package dao;

import services.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO implements DAO<User> {

    private Connection conn;

    public UserDAO() {
    }

    public UserDAO(DBConnection dbConn) {
        this.conn = dbConn.getConnection();
    }

    @Override
    public boolean add(User obj) throws SQLException {
        String sql = "INSERT INTO users (username, password, email, phone_number, gender) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, obj.getUsername());
        preparedStatement.setString(2, obj.getPassword());
        preparedStatement.setString(3, obj.getEmail());
        preparedStatement.setString(4, obj.getPhone());
        preparedStatement.setString(5, obj.getGender());
        if (preparedStatement.executeUpdate() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean edit(int id) throws SQLException {
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public List<User> findByName(String query) {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    public boolean isLogged(String username, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }
}
