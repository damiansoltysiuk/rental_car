package controller.servlet;

import model.user.User;
import service.UserManagementService;
import service.impl.UserManagementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(name = "UserListServlet", urlPatterns = {"/users", "/userList", "/user"})
public class UserListServlet extends HttpServlet {
    UserManagementService userManagementService;

    @Override
    public void init() throws ServletException {
        userManagementService = new UserManagementServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<User> users = userManagementService.getUsers();
        req.setAttribute("users", users);
        req.getRequestDispatcher("userList.jsp").forward(req, resp);
    }
}
