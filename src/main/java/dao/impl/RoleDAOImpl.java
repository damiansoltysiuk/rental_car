package dao.impl;

import dao.AbstractDAO;
import dao.RoleDAO;
import model.user.Role;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class RoleDAOImpl extends AbstractDAO implements RoleDAO {
    @Override
    public void saveRole(Role role) {
        hibernateUtil.save(role);
    }

    @Override
    public Role getRoleById(Integer roleID) {
        return entityManager.createQuery("SELECT r FROM Role r WHERE r.roleID =:roleID", Role.class)
                .setParameter("roleID",roleID)
                .getSingleResult();
    }

    @Override
    public List<Role> getListRole() {
        return hibernateUtil.getEntityManager().createQuery("SELECT r FROM Role r", Role.class).getResultList();
    }

    @Override
    public void update(Integer roleID, Role editedRole) {
        EntityManager entityManager = hibernateUtil.getEntityManager();
        EntityTransaction transaction = hibernateUtil.getEntityManager().getTransaction();
        Role role = entityManager.find(Role.class, roleID);
        transaction.begin();
        role.setRoleName(editedRole.getRoleName());
        entityManager.merge(role);
        transaction.commit();
    }

    @Override
    public void delete(Integer roleID) {
        hibernateUtil.delete(Role.class, roleID);
    }
}
