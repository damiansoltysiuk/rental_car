package service.impl;

import dao.CarDAO;
import dao.impl.CarDAOImpl;
import model.car.Car;
import service.CarManagementService;

import javax.persistence.NoResultException;

public class CarManagementServiceImpl implements CarManagementService {
    private CarDAO carDAO;

    public CarManagementServiceImpl() {
        this.carDAO = new CarDAOImpl();
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
    public boolean registrationNumberIsExist(String registrationNumber) {
        try {
            Car car = carDAO.getCarByRegisterNumber(registrationNumber);
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }
}
