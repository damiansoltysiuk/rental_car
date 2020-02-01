package service.impl;

import dao.RoleDAO;
import dao.UserDAO;
import dao.impl.RoleDAOImpl;
import dao.impl.UserDAOImpl;
import model.user.Role;
import model.user.User;
import service.UserManagementService;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Set;

public class UserManagementServiceImpl implements UserManagementService {
    private UserDAO userDAO;
    private RoleDAO roleDAO;

    public UserManagementServiceImpl() {
        this.userDAO = new UserDAOImpl();
        this.roleDAO = new RoleDAOImpl();
    }

    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public void deleteUser(Integer userID) {
        userDAO.deleteUser(userID);
    }

    @Override
    public void updateUser(Integer userID, User editedUser) {
        userDAO.updateUser(userID, editedUser);
    }

    @Override
    public boolean isUserValid(String login, String password) {
        try {
            return userDAO.getUserByLogin(login).getPassword().equals(password);
        } catch (NoResultException e) {
            return false;
        }
    }

    @Override
    public boolean isLoginExist(String login) {
        try {
            User user = userDAO.getUserByLogin(login);
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    @Override
    public boolean isEmailExist(String email) {
        try {
            User user = userDAO.getUserByEmail(email);
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    @Override
    public boolean isPhoneNumberExist(String phone) {
        try {
            User user = userDAO.getUserByTelephone(phone);
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    @Override
    public Set<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    public User getUserByID(Integer userID) {
        return userDAO.getUserByID(userID);
    }

    @Override
    public void saveRole(Role role) {
        roleDAO.saveRole(role);
    }

    @Override
    public Role getRoleById(Integer roleID) {
        return roleDAO.getRoleById(roleID);
    }

    @Override
    public List<Role> getListRole() {
        return roleDAO.getListRole();
    }

    @Override
    public void update(Integer roleID, Role editedRole) {
        roleDAO.update(roleID, editedRole);
    }

    @Override
    public void delete(Integer roleID) {
        roleDAO.delete(roleID);
    }
}
