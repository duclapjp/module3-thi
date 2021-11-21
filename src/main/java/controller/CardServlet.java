package controller;

import model.Book;
import model.Card;
import service.CardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CardServlet", value = "/cards")
public class CardServlet extends HttpServlet {
    private static CardService cardService =new CardService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            default:
                try {
                    listCard(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void listCard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Card> cardList = cardService.findAll();
        request.setAttribute("cards", cardList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/card/list.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
