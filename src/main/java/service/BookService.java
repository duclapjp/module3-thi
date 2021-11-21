package service;

import connectionSingleton.SingletonConnection;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService implements InterfaceAll<Book> {
    private static Connection connection = SingletonConnection.getConnection();
    private Book book = new Book();
    private static final String SELECT_ALL_BOOK = "select *from book";
    private static final String SELECT_BOOK_BY_ID = "select *from book where id=?";
    private static final String UPDATE_BOOK_SQL = "update book set quantity=? where id = ?";

    @Override
    public List<Book> findAll() throws SQLException {
        List<Book> books = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOK);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String author = resultSet.getString("author");
            String description = resultSet.getString("description");
            int quantity = resultSet.getInt("quantity");
            books.add(new Book(id, name, author, description, quantity));
        }
        return books;
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public Book findById(int id) throws SQLException {
        Book book = new Book();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id1 = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String author = resultSet.getString("author");
            String description = resultSet.getString("description");
            int quantity = resultSet.getInt("quantity");
            book = new Book(id1, name, author, description, quantity);
        }
        return book;
    }

    @Override
    public boolean update(Book book) throws SQLException {
        boolean update;
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK_SQL);
        preparedStatement.setInt(1, book.getQuantity() - 1);
        preparedStatement.setInt(2, book.getId());
        update = preparedStatement.executeUpdate() > 0;
        return update;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public Book findByCard(String name) throws SQLException {
        return null;
    }
}

