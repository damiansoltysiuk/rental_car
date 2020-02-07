package dao;

import model.car.Model;

public interface ModelDAO {
    void save(Model model);
    Model getModelByID(Integer ID);
    void delete(Integer ID);
    void update(Integer ID, Model editedModel);
    Integer findIdModel(Model model);
}
