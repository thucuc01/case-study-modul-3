package controller;

import dao.UserDAO;
import services.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controller.UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();
    RequestDispatcher dispatcher = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("act");
        if (action != null) {
            switch (action) {
                case "add-new":
                    addNewProduct(req, resp);
                    break;
                default:
                    showAllProduct(req, resp);
            }
        } else {
            dispatcher = req.getRequestDispatcher("admin/error-404.jsp");
        }
        dispatcher.forward(req, resp);
    }

    public void showAllProduct(HttpServletRequest req, HttpServletResponse resp) {
        List<User> users = userDAO.getAll();
        req.setAttribute("users", users);
    }

    private void addNewProduct(HttpServletRequest req, HttpServletResponse resp) {
        dispatcher = req.getRequestDispatcher("admin/users/add-new.jsp");
    }
}
