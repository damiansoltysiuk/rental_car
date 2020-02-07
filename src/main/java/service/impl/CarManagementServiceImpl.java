package service.impl;

import dao.CarDAO;
import dao.EquipmentVersionDAO;
import dao.ModelDAO;
import dao.impl.CarDAOImpl;
import dao.impl.EquipmentVersionDAOImpl;
import dao.impl.ModelDAOImpl;
import model.car.Car;
import model.car.EquipmentVersion;
import model.car.Model;
import service.CarManagementService;

import javax.persistence.NoResultException;
import java.util.List;

public class CarManagementServiceImpl implements CarManagementService {
    private CarDAO carDAO;
    private ModelDAO modelDAO;
    private EquipmentVersionDAO equipmentVersionDAO;

    public CarManagementServiceImpl() {
        this.carDAO = new CarDAOImpl();
        this.modelDAO = new ModelDAOImpl();
        this.equipmentVersionDAO = new EquipmentVersionDAOImpl();
    }

    @Override
    public List<Car> getCars() {
        return carDAO.getCars();
    }

    @Override
    public Car getCarByID(Integer ID) {
        return carDAO.getCarByCarID(ID);
    }

    @Override
    public void saveCar(Car car) {
        carDAO.saveCar(car);
    }

    @Override
    public void deleteCar(Integer carID) {
        carDAO.deleteCar(carID);
    }

    @Override
    public void updateCar(Integer ID, Car updatedCar) {
        carDAO.updateCar(ID, updatedCar);
    }

    @Override
    public boolean registrationNumberIsExist(String registrationNumber) {
        try {
            Car car = carDAO.getCarByRegisterNumber(registrationNumber);
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    @Override
    public Boolean isExistEquipmentVersion(EquipmentVersion equipmentVersion) {
        return equipmentVersionDAO.findID(equipmentVersion) > 0;
    }

    @Override
    public void saveEquipmentVersion(EquipmentVersion ev) {
        equipmentVersionDAO.save(ev);
    }

    @Override
    public EquipmentVersion findEquipmentVersionByID(Integer ID) {
        return equipmentVersionDAO.findByID(ID);
    }

    @Override
    public List<EquipmentVersion> findEquipmentVersionByDescription(String description) {
        return equipmentVersionDAO.findByDescription(description);
    }

    @Override
    public EquipmentVersion findPrimaryEquipmentVersion(EquipmentVersion equipmentVersion) {
        Integer ID = equipmentVersionDAO.findID(equipmentVersion);
        if(ID < 0) {
            return equipmentVersion;
        }
        return equipmentVersionDAO.findByID(ID);
    }

    @Override
    public List<EquipmentVersion> findAllEquipmentVersion() {
        return equipmentVersionDAO.findAll();
    }

    @Override
    public void updateEquipmentVersion(Integer ID, EquipmentVersion ev) {
        equipmentVersionDAO.update(ID, ev);
    }

    @Override
    public void deleteEquipmentVersion(Integer ID) {
        equipmentVersionDAO.delete(ID);
    }

    @Override
    public void saveModel(Model model) {
        modelDAO.save(model);
    }

    @Override
    public Model findModelByID(Integer ID) {
        return modelDAO.getModelByID(ID);
    }

    @Override
    public void updateModel(Integer ID, Model editedModel) {
        modelDAO.update(ID, editedModel);
    }

    @Override
    public void deleteModel(Integer ID) {
        modelDAO.delete(ID);
    }

    @Override
    public Model findPrimaryModel(Model model) {
        Integer ID = modelDAO.findIdModel(model);
        if(ID < 0) {
            return model;
        }
        return modelDAO.getModelByID(ID);
    }

    @Override
    public Boolean isExistModel(Model model) {
        return modelDAO.findIdModel(model) > 0;
    }
}
