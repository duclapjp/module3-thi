package service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface InterfaceAll<T> {
    List<T> findAll() throws SQLException;

    void save(T t) throws SQLException;

    T findById(int id) throws SQLException;

    boolean update(T t) throws SQLException;

    boolean deleteById(int id) throws SQLException;
    T findByCard(String name) throws SQLException;
}
