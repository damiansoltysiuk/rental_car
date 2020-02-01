package dao.impl;

import dao.AbstractDAO;
import dao.UserDAO;
import model.user.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDAOImpl extends AbstractDAO implements UserDAO {
    @Override
    public void saveUser(User user) {
        hibernateUtil.save(user);
    }

    @Override
    public void deleteUser(Integer userID) {
        hibernateUtil.delete(User.class, userID);
    }

    @Override
    public void updateUser(Integer userID, User editedUser) {
        EntityManager entityManager = hibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        User user = entityManager.find(User.class, userID);
        transaction.begin();
        user.setLogin(editedUser.getLogin());
        user.setPassword(editedUser.getPassword());
        user.setEmail(editedUser.getPassword());
        user.setUserName(editedUser.getUserName());
        user.setUserSurname(editedUser.getUserSurname());
        user.setAddress(editedUser.getAddress());
        user.setUserStatus(editedUser.getUserStatus());
        user.setPhoneNumber(editedUser.getPhoneNumber());
        user.setDiscount(editedUser.getDiscount());
        entityManager.merge(user);
        transaction.commit();
    }

    @Override
    public User getUserByLogin(String login) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.login = :login", User.class);
        query.setParameter("login", login);
        return query.getSingleResult();
    }

    @Override
    public User getUserByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

    @Override
    public User getUserByTelephone(String telephone) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.phoneNumber = :phone", User.class);
        query.setParameter("phone", telephone);
        return query.getSingleResult();
    }

    @Override
    public Set<User> getUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList().stream().collect(Collectors.toSet());
    }

    @Override
    public User getUserByID(Integer userID) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.id =:userID", User.class)
                .setParameter("userID", userID)
                .getSingleResult();
    }
}
