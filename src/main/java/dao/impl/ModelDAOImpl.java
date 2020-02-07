package dao.impl;

import dao.AbstractDAO;
import dao.ModelDAO;
import model.car.Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

public class ModelDAOImpl extends AbstractDAO implements ModelDAO {
    @Override
    public void save(Model model) {
        hibernateUtil.save(model);
    }

    @Override
    public Model getModelByID(Integer ID) {
        return hibernateUtil.getEntityManager()
                .createQuery("SELECT m FROM Model m WHERE m.modelID=:modelID", Model.class)
                .setParameter("modelID", ID)
                .getSingleResult();
    }

    @Override
    public void delete(Integer ID) {
        hibernateUtil.delete(Model.class, ID);
    }

    @Override
    public void update(Integer ID, Model editedModel) {
        EntityManager entityManager = hibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Model model = entityManager.find(Model.class, ID);
        transaction.begin();
        model.setName(editedModel.getName());
        model.setGeneration(editedModel.getGeneration());
        model.setCarType(editedModel.getCarType());
        model.setEquipmentVersion(editedModel.getEquipmentVersion());
        model.setFotoDirectory(editedModel.getFotoDirectory());
        entityManager.merge(model);
        transaction.commit();
    }

    @Override
    public Integer findIdModel(Model model) {
        try {
            Model result = hibernateUtil.getEntityManager().createQuery("SELECT m FROM Model m WHERE m.name=:name AND m.generation=:generation AND m.fotoDirectory=:photo AND m.carType=:carType AND m.equipmentVersion.equipmentVersionID=:evID", Model.class)
                    .setParameter("name", model.getName())
                    .setParameter("generation", model.getGeneration())
                    .setParameter("photo", model.getFotoDirectory())
                    .setParameter("carType", model.getCarType())
                    .setParameter("evID", model.getEquipmentVersion().getEquipmentVersionID())
                    .getSingleResult();
            return result.getModelID();
        } catch (NoResultException e) {
            return -1;
        }
    }
}
