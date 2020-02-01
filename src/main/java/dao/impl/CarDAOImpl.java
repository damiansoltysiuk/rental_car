package dao.impl;

import dao.AbstractDAO;
import dao.CarDAO;
import model.car.Car;
import model.car.CarMark;
import model.car.CarStatus;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.Set;
import java.util.stream.Collectors;

public class CarDAOImpl extends AbstractDAO implements CarDAO {
    @Override
    public void saveCar(Car car) {
        hibernateUtil.save(car);
    }

    @Override
    public void deleteCar(Integer carID) {
        hibernateUtil.delete(Car.class, carID);
    }

    @Override
    public void updateCar(Integer carID, Car updateCar) {
        EntityManager entityManager = hibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Car car = entityManager.find(Car.class, carID);

        transaction.begin();
        car.setRegistrationNumber(updateCar.getRegistrationNumber());
        car.setMark(updateCar.getMark());
        car.setFuelLevel(updateCar.getFuelLevel());
        car.setProductionYear(updateCar.getProductionYear());
        car.setCarConditionNote(updateCar.getCarConditionNote());
        car.setCarStatus(updateCar.getCarStatus());
        entityManager.merge(car);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public Car getCarByCarID(Integer carID) {
        TypedQuery<Car> query = entityManager.createQuery("SELECT c FROM Car c WHERE c.carID = :carID", Car.class);
        query.setParameter("carID", carID);
        return query.getSingleResult();
    }

    @Override
    public Car getCarByRegisterNumber(String registerNumber) {
        TypedQuery<Car> query = entityManager.createQuery("SELECT c FROM Car c WHERE c.registrationNumber = :registerNumber", Car.class);
        query.setParameter("registerNumber", registerNumber);
        return query.getSingleResult();
    }

    @Override
    public Set<Car> getCarsByMark(CarMark carMark) {
        TypedQuery<Car> query = entityManager.createQuery("SELECT c FROM Car c WHERE c.mark = :carMark", Car.class);
        query.setParameter("carMark", carMark);
        return query.getResultList().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<Car> getCarsByProductionYear(Integer yearProduction) {
        TypedQuery<Car> query = entityManager.createQuery("SELECT c FROM Car c WHERE c.productionYear = :year", Car.class);
        query.setParameter("year", yearProduction);
        return query.getResultList().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<Car> getCarsByCarStatus(CarStatus carStatus) {
        TypedQuery<Car> query = entityManager.createQuery("SELECT c FROM Car c WHERE c.carStatus = :status", Car.class);
        query.setParameter("status", carStatus);
        return query.getResultList().stream().collect(Collectors.toSet());
    }
}
