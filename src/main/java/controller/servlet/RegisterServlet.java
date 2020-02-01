package controller.servlet;

import controller.error.ValidationError;
import model.user.Address;
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

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    private UserManagementService service;
    private List<ValidationError> errors;

    @Override
    public void init() throws ServletException {
        service = new UserManagementServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        errors = new ArrayList<>();

        String password = req.getParameter(USER_PASSWORD);
        String repeatedPassword = req.getParameter(USER_REPEATED_PASSWORD);
        if (!password.equals(repeatedPassword)) {
            errors.add(new ValidationError(ERROR_HEADER_PASSWORD, ERROR_MESSAGE_PASSWORD));
        }

        String login = req.getParameter(USER_LOGIN);
        if (service.isLoginExist(login)) {
            errors.add(new ValidationError(ERROR_HEADER_LOGIN, ERROR_MESSAGE_LOGIN));
        }

        String email = req.getParameter(USER_EMAIL);
        if (service.isEmailExist(email)) {
            errors.add(new ValidationError(ERROR_HEADER_EMAIL, ERROR_MESSAGE_EMAIL));
        }


        String phoneNumber = req.getParameter(USER_PHONE_NUMBER);
        if (service.isPhoneNumberExist(phoneNumber)) {
            errors.add(new ValidationError(ERROR_HEADER_PHONE, ERROR_MESSAGE_PHONE));
        }

        if (errors.size() != 0) {
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        String name = req.getParameter(USER_NAME);
        String surname = req.getParameter(USER_SURNAME);

        Address userAddress = new Address();
        userAddress.setCity(req.getParameter(ADDRESS_POST_TOWN));
        userAddress.setCountry(req.getParameter(ADDRESS_COUNTRY));
        userAddress.setFlatNo(req.getParameter(ADDRESS_FLAT_NUMBER));
        userAddress.setStreet(req.getParameter(ADDRESS_STREET));
        userAddress.setZipCode(req.getParameter(ADDRESS_ZIP_CODE));

        String address = userAddress.toString();

        User user = new User.Builder().login(login).password(password).email(email).userName(name).userSurname(surname)
                .address(address).discount(0).phoneNumber(phoneNumber).userStatus(UserStatus.NORMAL_CLIENT).build();
        user.setRole(service.getRoleById(3));

        service.saveUser(user);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
