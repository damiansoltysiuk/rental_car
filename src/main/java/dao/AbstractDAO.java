package dao;

import util.HibernateUtil;

import javax.persistence.EntityManager;

public class AbstractDAO {
    protected final HibernateUtil hibernateUtil = HibernateUtil.getInstance();
    protected final EntityManager entityManager = hibernateUtil.getEntityManager();
}
