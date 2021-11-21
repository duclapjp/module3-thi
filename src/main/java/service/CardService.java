package service;

import connectionSingleton.SingletonConnection;
import model.Book;
import model.Card;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardService implements InterfaceAll<Card> {
    private static Connection connection = SingletonConnection.getConnection();
    private static BookService bookService = new BookService();
    private static StudentService studentService = new StudentService();
    private Card card = new Card();
    private static final String SELECT_ALL_CARD = "select *from card";
    private static final String SELECT_CARD_BY_ID = "select *from card where id=?";
    private static final String INSERT_CARD = "insert into card (ms, ms_student, borrow_day, back_day) VALUES (?,?,?,?)";
    public static final String SELECT_FROM_CARD_NAME = "select *from card where name =?";
    @Override
    public List<Card> findAll() throws SQLException {
        List<Card> cards = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CARD);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int ms = resultSet.getInt("ms");
            int ms_student = resultSet.getInt("ms_student");
            Date borrow_day = resultSet.getDate("borrow_day");
            Date back_day = resultSet.getDate("back_day");
            Book book = bookService.findById(ms);
            Student student = studentService.findById(ms_student);
            cards.add(new Card(id, book, student,borrow_day, back_day));
        }
        return cards;
    }

    @Override
    public void save(Card card) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CARD);
        preparedStatement.setInt(1, card.getBook().getId());
        preparedStatement.setInt(2, card.getStudent().getId());
        preparedStatement.setDate(3, card.getBorrow_day());
        preparedStatement.setDate(4, card.getBack_day());
        preparedStatement.executeUpdate();
    }

    @Override
    public Card findById(int id) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Card card) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public Card findByCard(String name) throws SQLException {
        return null;
    }
}
