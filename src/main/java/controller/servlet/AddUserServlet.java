package controller.servlet;

import controller.error.ValidationError;
import model.user.Role;
import model.user.User;
import model.user.UserStatus;
import service.UserManagementService;
import service.impl.UserManagementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static util.Namespace.*;

@WebServlet(name = "AddUserServlet", urlPatterns = "/addUser")
public class AddUserServlet extends HttpServlet {
    private UserManagementService service;
    private List<ValidationError> errors;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Role> listRole = service.getListRole();
        req.setAttribute("listRole", listRole);
        req.getRequestDispatcher("addUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        errors = new ArrayList<>();
        String login = req.getParameter(USER_LOGIN);
        if(service.isLoginExist(login)) {
            errors.add(new ValidationError(ERROR_HEADER_LOGIN, ERROR_MESSAGE_LOGIN));
        }
        String email = req.getParameter(USER_EMAIL);
        if(service.isEmailExist(email)) {
            errors.add(new ValidationError(ERROR_HEADER_EMAIL, ERROR_MESSAGE_EMAIL));
        }
        String phoneNumber = req.getParameter(USER_PHONE_NUMBER);
        if(service.isPhoneNumberExist(phoneNumber)) {
            errors.add(new ValidationError(ERROR_HEADER_PHONE, ERROR_MESSAGE_PHONE));
        }
        if(req.getParameter(USER_ROLE) == null) {
            errors.add(new ValidationError(ERROR_HEADER_USER_ROLE, ERROR_MESSAGE_USER_ROLE));
        }
        if(errors.size() != 0) {
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/addUser.jsp").forward(req, resp);
            return;
        }
        String password = req.getParameter(USER_PASSWORD);
        String name = req.getParameter(USER_NAME);
        String surname = req.getParameter(USER_SURNAME);
        String address = req.getParameter(USER_ADDRESS);
        UserStatus userStatus = stringToUserStatus(req.getParameter(USER_STATUS));
        Integer discount = Integer.parseInt(req.getParameter(USER_DISCOUNT));

        User userToAdd = new User.Builder().login(login).email(email).password(password)
                .userName(name).userSurname(surname).address(address)
                .discount(discount).phoneNumber(phoneNumber).userStatus(userStatus).build();
        userToAdd.setRole(service.getRoleById(stringRoleToRoleID(req.getParameter(USER_ROLE))));

        service.saveUser(userToAdd);

        req.getRequestDispatcher("users").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        service = new UserManagementServiceImpl();
    }

    private UserStatus stringToUserStatus(String str) {
        switch (str) {
            case "BANNED": return UserStatus.BANNED;
            case "NORMAL_CLIENT": return UserStatus.NORMAL_CLIENT;
            case "KEY_CLIENT": return UserStatus.KEY_CLIENT;
            case "EMPLOYEE": return UserStatus.EMPLOYEE;
            default: throw new IllegalArgumentException("Please select existed user status");
        }
    }

    private Integer stringRoleToRoleID(String str) {
        switch (str) {
            case "ADMIN": return 1;
            case "MODERATOR": return 2;
            case "USER": return 3;
            default: throw new IllegalArgumentException("Please select existed user role");
        }
    }
}
