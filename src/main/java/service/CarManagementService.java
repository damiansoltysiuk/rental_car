package service;

import model.car.Car;
import model.car.EquipmentVersion;
import model.car.Model;

import java.util.List;

public interface CarManagementService {
    void saveCar(Car car);
    void deleteCar(Integer carID);
    boolean registrationNumberIsExist(String registrationNumber);
    List<Car> getCars();
    Car getCarByID(Integer ID);
    void updateCar(Integer ID, Car updatedCar);

    void saveEquipmentVersion(EquipmentVersion ev);
    EquipmentVersion findEquipmentVersionByID(Integer ID);
    EquipmentVersion findPrimaryEquipmentVersion(EquipmentVersion equipmentVersion);
    List<EquipmentVersion> findEquipmentVersionByDescription(String description);
    Boolean isExistEquipmentVersion(EquipmentVersion equipmentVersion);
    List<EquipmentVersion> findAllEquipmentVersion();
    void updateEquipmentVersion(Integer ID, EquipmentVersion ev);
    void deleteEquipmentVersion(Integer ID);

    void saveModel(Model model);
    Model findModelByID(Integer ID);
    void updateModel(Integer ID, Model editedModel);
    void deleteModel(Integer ID);
    Model findPrimaryModel(Model model);
    Boolean isExistModel(Model model);

}
