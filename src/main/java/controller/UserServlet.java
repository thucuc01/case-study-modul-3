package controller;

import dao.DBConnection;
import dao.UserDAO;
import services.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "controller.UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private final DBConnection dbConn = new DBConnection();
    private final UserDAO userDAO = new UserDAO(dbConn);
    private RequestDispatcher dispatcher = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, SQLException {
        String action = req.getParameter("act");
        if (action != null) {
            switch (action) {
                case "create":
                    createUser(req, resp);
                    break;
                case "store":
                    updateUser(req, resp);
                default:
                    index(req, resp);
            }
        } else {
            dispatcher = req.getRequestDispatcher("admin/error-404.jsp");
        }
    }

    public void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userDAO.getAll();
        req.setAttribute("users", users);
        dispatcher.forward(req, resp);
    }

    private void createUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatcher = req.getRequestDispatcher("admin/users/create.jsp");
        dispatcher.forward(req, resp);
    }

    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        HttpSession session = req.getSession();
        if (req.getParameter("username").isEmpty()) {
            String errors = "Username is requered!";
            System.out.println(errors);
        }
        if (req.getParameter("email").isEmpty()) {
            String errors = "Email is requered!";
            System.out.println(errors);
        }
        if (req.getParameter("password").isEmpty()) {
            String errors = "Password is requered!";
            System.out.println(errors);
        }
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setEmail(req.getParameter("email"));
        user.setPhone(req.getParameter("phone"));
        user.setGender(req.getParameter("gender"));
        if (userDAO.add(user)) {
            session.setAttribute("msg", "New user created successfully.");
        } else {
            session.setAttribute("msg", "INSERT fails.");
        }
        resp.sendRedirect("/users?act=create");
    }
}
