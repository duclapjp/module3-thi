package controller;

import model.Book;
import model.Card;
import model.Student;
import service.BookService;
import service.CardService;
import service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet", value = "/books")
public class BookServlet extends HttpServlet {
    private static BookService bookService = new BookService();
    private static StudentService studentService = new StudentService();
    private static CardService cardService = new CardService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "borrow":
                try {
                    showBorrowBook(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            default:
                try {
                    listAllBook(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void showBorrowBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.findById(id);
        List<Student> students = studentService.findAll();
        request.setAttribute("students", students);
        request.setAttribute("book", book);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/book/borrow.jsp");
        requestDispatcher.forward(request, response);
    }

    private void listAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Book> books = bookService.findAll();
        request.setAttribute("books", books);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/book/list.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "borrow":
                try {
                    borrowBook(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listAllBook(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void borrowBook(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws SQLException, ServletException, IOException {
            int name = Integer.parseInt(request.getParameter("ms"));
            Book book = bookService.findById(name);
            int ms_student = Integer.parseInt(request.getParameter("name"));
            Student student = studentService.findById(ms_student);
            Date borrow_day = Date.valueOf(request.getParameter("borrowDay"));
            Date back_day = Date.valueOf(request.getParameter("backDay"));
            Card card = new Card(book, student, borrow_day, back_day);
            cardService.save(card);
            bookService.update(book);
            response.sendRedirect("/books");
        }
    }
