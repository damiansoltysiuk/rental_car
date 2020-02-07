package dao.impl;

import dao.AbstractDAO;
import dao.EquipmentVersionDAO;
import model.car.EquipmentVersion;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class EquipmentVersionDAOImpl extends AbstractDAO implements EquipmentVersionDAO {
    @Override
    public void save(EquipmentVersion ev) {
        hibernateUtil.save(ev);
    }

    @Override
    public EquipmentVersion findByID(Integer evID) {
        return hibernateUtil.getEntityManager()
                .createQuery("SELECT e FROM EquipmentVersion e WHERE e.id =:id", EquipmentVersion.class)
                .setParameter("id", evID)
                .getSingleResult();
    }

    @Override
    public List<EquipmentVersion> findByEquipmentName(String equipmentName) {
        return entityManager.createQuery("SELECT e FROM EquipmentVersion e WHERE e.equipmentName= :equipmentName", EquipmentVersion.class)
                .setParameter("equipmentName", equipmentName)
                .getResultList();
    }

    @Override
    public EquipmentVersion findPrimaryEquipmentVersion(EquipmentVersion equipmentVersion) {
        return hibernateUtil.getEntityManager()
                .createQuery("SELECT e FROM EquipmentVersion  e WHERE e.equipmentDescription=:description AND e.equipmentName=:name", EquipmentVersion.class)
                .setParameter("description", equipmentVersion.getEquipmentDescription())
                .setParameter("name", equipmentVersion.getEquipmentName())
                .getSingleResult();
    }

    @Override
    public List<EquipmentVersion> findAll() {
        return entityManager
                .createQuery("SELECT e FROM EquipmentVersion e", EquipmentVersion.class)
                .getResultList();
    }

    @Override
    public List<EquipmentVersion> findByDescription(String description) {
        String[] strings = description.replace(" ", "").split(",");
        StringBuilder queryStringPhrase = new StringBuilder("SELECT ev FROM EquipmentVersion ev");
        for (String str : strings) {
            if (!(queryStringPhrase.toString().contains("WHERE"))) {
                queryStringPhrase.append(" WHERE");
            } else {
                queryStringPhrase.append(" AND");
            }
            queryStringPhrase.append(" ev.equipmentDescription LIKE ").append("'" + str + "'");
        }
        return entityManager.createQuery(queryStringPhrase.toString(), EquipmentVersion.class).getResultList();
    }

    @Override
    public Integer findID(EquipmentVersion equipmentVersion) {
        try {
            EquipmentVersion ev = findPrimaryEquipmentVersion(equipmentVersion);
            return ev.getEquipmentVersionID();
        } catch (NoResultException e) {
            return -1;
        }
    }

    @Override
    public void update(Integer evID, EquipmentVersion equipmentVersion) {
        EntityTransaction transaction = entityManager.getTransaction();
        EquipmentVersion ev = entityManager.find(EquipmentVersion.class, evID);

        transaction.begin();
        ev.setEquipmentName(equipmentVersion.getEquipmentName());
        ev.setEquipmentDescription(equipmentVersion.getEquipmentDescription());
        entityManager.merge(ev);
        transaction.commit();
    }

    @Override
    public void delete(Integer ID) {
        hibernateUtil.delete(EquipmentVersion.class, ID);
    }
}
