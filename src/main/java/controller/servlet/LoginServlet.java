package controller.servlet;

import controller.error.ValidationError;
import service.UserManagementService;
import service.impl.UserManagementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.Namespace.*;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login", ""})
public class LoginServlet extends HttpServlet {
    private final static Integer SECONDS_PED_DAY = 24 * 60 * 60;
    UserManagementService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(USER_LOGIN);
        String password = req.getParameter(USER_PASSWORD);
        boolean isRememberChecked = CHECKBOX_CHECKED.equals(req.getParameter(REMEMBER));
        if (login == null || password == null) {
            login = (String) req.getAttribute(USER_LOGIN);
            password = (String) req.getAttribute(USER_PASSWORD);
        }

        if (!service.isUserValid(login, password)) {
            ValidationError error = new ValidationError(LOGIN_OR_PASSWORD_ERROR_HEADER, LOGIN_OR_PASSWORD_ERROR_MESSAGE);
            req.setAttribute("errors", error);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }

        req.getSession().setAttribute(USER_LOGIN, login);
        if (isRememberChecked) {
            Cookie loginCookie = new Cookie(USER_LOGIN, login);
            Cookie passwordCookie = new Cookie(USER_PASSWORD, password);
            loginCookie.setMaxAge(SECONDS_PED_DAY);
            passwordCookie.setMaxAge(SECONDS_PED_DAY);
            resp.addCookie(loginCookie);
            resp.addCookie(passwordCookie);
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        service = new UserManagementServiceImpl();
    }
}
