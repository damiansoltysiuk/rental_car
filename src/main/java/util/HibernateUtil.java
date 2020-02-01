package util;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static HibernateUtil instance = null;
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rentalCarApp");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static HibernateUtil getInstance() {
        if (instance == null) {
            instance = new HibernateUtil();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void save(Object o) {
        entityManager.getTransaction().begin();
        if (!entityManager.contains(o)) {
            entityManager.persist(o);
            entityManager.flush();
        }
        entityManager.getTransaction().commit();
    }

    public void delete(Class clazz, Integer objectID) {
        Session session = entityManager.unwrap(Session.class);
        Object toRemove = entityManager.find(clazz, objectID);
        entityManager.getTransaction().begin();
        session.delete(toRemove);
        entityManager.getTransaction().commit();
    }
}
