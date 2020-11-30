package dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    boolean add(T obj) throws SQLException;
    boolean remove(int id) throws SQLException;
    boolean edit(int id) throws SQLException;
    List<T> getAll();
    List<T> findByName(String query);
    T findById(int id);
}
