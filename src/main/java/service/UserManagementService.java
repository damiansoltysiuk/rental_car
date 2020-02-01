package service;

import model.user.Role;
import model.user.User;

import java.util.List;
import java.util.Set;

public interface UserManagementService {
    void saveUser(User user);

    void deleteUser(Integer userID);

    void updateUser(Integer userID, User editedUser);

    boolean isUserValid(String login, String password);

    boolean isLoginExist(String login);

    boolean isEmailExist(String email);

    boolean isPhoneNumberExist(String phone);

    Set<User> getUsers();

    User getUserByID(Integer userID);

    void saveRole(Role role);

    Role getRoleById(Integer roleID);

    List<Role> getListRole();

    void update(Integer roleID, Role editedRole);

    void delete(Integer roleID);
}
