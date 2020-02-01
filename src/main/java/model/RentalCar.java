package model;

import model.car.Car;
import model.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rental_car")
public class RentalCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_car_ID")
    private Integer rentalCarID;
    @Column(name = "date_from")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Column(name = "date_to")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @Column(name = "status")
    private String status;
    @Column(name = "charge")
    private Double charge;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "car_ID")
    private Car car;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_ID")
    private User user;

    public RentalCar() {}

    private RentalCar(Date dateFrom, Date dateTo, String status, Double charge) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.status = status;
        this.charge = charge;
    }

    public Integer getRentalCarID() {
        return rentalCarID;
    }

    public void setRentalCarID(Integer rentalCarID) {
        this.rentalCarID = rentalCarID;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getCharge() {
        return charge;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static class Builder {
        private Date dateFrom;
        private Date dateTo;
        private String status;
        private Double charge;

        public Builder dateFrom(Date dateFrom) {
            this.dateFrom = dateFrom;
            return this;
        }

        public Builder dateTo(Date dateTo) {
            this.dateTo = dateTo;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder charge(Double charge) {
            this.charge = charge;
            return this;
        }

        public RentalCar build() {
            return new RentalCar(dateFrom,dateTo,status,charge);
        }
    }
}
