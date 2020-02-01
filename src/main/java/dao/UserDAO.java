package dao;

import model.user.User;

import java.util.Set;

public interface UserDAO {
    void saveUser(User user);
    void deleteUser(Integer userID);
    void updateUser(Integer userID, User editedUser);
    User getUserByLogin(String login);
    User getUserByTelephone(String telephone);
    User getUserByEmail(String email);
    Set<User> getUsers();
    User getUserByID(Integer userID);
//    void updateUser(User user);
}