package service;

import connectionSingleton.SingletonConnection;
import model.Book;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements InterfaceAll<Student> {
    private Student student = new Student();
    private static Connection connection = SingletonConnection.getConnection();
    private static final String SELECT_ALL_STUDENT = "select *from student";
    private static final String SELECT_STUDENT_BY_ID = "select *from student where id=?";

    @Override
    public List<Student> findAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String classId = resultSet.getString("classId");
            students.add(new Student(id, name, classId));
        }
        return students;
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public Student findById(int id) throws SQLException {
        Student student = new Student();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id1 = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String classId = resultSet.getString("classId");
            student = new Student(id1, name, classId);
        }
        return student;
    }

    @Override
    public boolean update(Student student) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public Student findByCard(String name) throws SQLException {
        return null;
    }


}
