package service;

import model.car.Car;

public interface CarManagementService {
    void saveCar(Car car);
    void deleteCar(Integer carID);
    boolean registrationNumberIsExist(String registrationNumber);
}
