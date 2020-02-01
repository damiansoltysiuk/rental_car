package dao;

import model.car.Car;
import model.car.CarMark;
import model.car.CarStatus;

import java.util.Set;

public interface CarDAO {
    void saveCar(Car car);
    void deleteCar(Integer carID);
    void updateCar(Integer carID, Car updateCar);
    Car getCarByCarID(Integer carID);
    Car getCarByRegisterNumber(String registerNumber);
    Set<Car> getCarsByMark(CarMark carMark);
    Set<Car> getCarsByProductionYear(Integer yearProduction);
    Set<Car> getCarsByCarStatus(CarStatus carStatus);
}
