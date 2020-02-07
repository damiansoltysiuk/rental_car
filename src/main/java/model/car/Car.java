package model.car;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_ID")
    private Integer carID;
    @Column(name = "registration_number", nullable = false, unique = true, length = 10)
    private String registrationNumber;
    @Column(name = "mark", nullable = false)
    @Enumerated(EnumType.STRING)
    private CarMark mark;
    @Column(name = "fuel_level", nullable = false)
    private Double fuelLevel;
    @Column(name = "production_year", nullable = false)
    private Integer productionYear;
    @Column(name = "car_condition_note", nullable = false, length = 500)
    private String carConditionNote;
    @Column(name = "car_status")
    @Enumerated(EnumType.STRING)
    private CarStatus carStatus;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "model_id")//, nullable = false)
    private Model model;

    public Car() {
    }

    public Car(String registrationNumber, CarMark mark, Double fuelLevel, Integer productionYear, String carConditionNote, CarStatus carStatus) {
        this.registrationNumber = registrationNumber;
        this.mark = mark;
        this.fuelLevel = fuelLevel;
        this.productionYear = productionYear;
        this.carConditionNote = carConditionNote;
        this.carStatus = carStatus;
    }

    public Integer getCarID() {
        return carID;
    }

    public void setCarID(Integer carID) {
        this.carID = carID;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public CarMark getMark() {
        return mark;
    }

    public void setMark(CarMark mark) {
        this.mark = mark;
    }

    public Double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(Double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public String getCarConditionNote() {
        return carConditionNote;
    }

    public void setCarConditionNote(String carConditionNote) {
        this.carConditionNote = carConditionNote;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public static class Builder {
        private Integer productionYear;
        private Double fuelLevel;
        private String registrationNumber;
        private CarMark mark;
        private String carConditionNote;
        private CarStatus carStatus;

        public Builder() {}

        public Builder productionYear(Integer productionYear) {
            this.productionYear = productionYear;
            return this;
        }

        public Builder fuelLevel(Double fuelLevel) {
            this.fuelLevel = fuelLevel;
            return this;
        }

        public Builder registrationNumber(String registrationNumber) {
            this.registrationNumber = registrationNumber;
            return this;
        }

        public Builder mark(CarMark mark) {
            this.mark = mark;
            return this;
        }

        public Builder carConditionNote(String carConditionNote) {
            this.carConditionNote=carConditionNote;
            return this;
        }

        public Builder carStatus(CarStatus carStatus) {
            this.carStatus = carStatus;
            return this;
        }

        public Car build() {
            return new Car(registrationNumber, mark, fuelLevel, productionYear, carConditionNote, carStatus);
        }
    }
}
