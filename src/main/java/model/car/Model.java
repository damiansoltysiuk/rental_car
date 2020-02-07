package model.car;

import javax.persistence.*;

@Entity
@Table(name = "model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Integer modelID;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "generation")
    private String generation;
    @Column(name = "foto_directory")
    private String fotoDirectory;
    @Column(name = "car_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private CarType carType;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "equipment_version_ID")
    private EquipmentVersion equipmentVersion;

    public Model() {
    }

    private Model(String name, String generation, String fotoDirectory, CarType carType) {
        this.name = name;
        this.generation = generation;
        this.fotoDirectory = fotoDirectory;
        this.carType = carType;
    }
    public Integer getModelID() {
        return modelID;
    }

    public void setModelID(Integer modelID) {
        this.modelID = modelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getFotoDirectory() {
        return fotoDirectory;
    }

    public void setFotoDirectory(String fotoDirectory) {
        this.fotoDirectory = fotoDirectory;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public EquipmentVersion getEquipmentVersion() {
        return equipmentVersion;
    }

    public void setEquipmentVersion(EquipmentVersion equipmentVersion) {
        this.equipmentVersion = equipmentVersion;
    }

    public static class Builder {
        private String name;
        private String generation;
        private String fotoDirectory;
        private CarType carType;

        public Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder generation(String generation) {
            this.generation = generation;
            return this;
        }

        public Builder fotoDirectory(String fotoDirectory) {
            this.fotoDirectory = fotoDirectory;
            return this;
        }

        public Builder carType(CarType carType) {
            this.carType = carType;
            return this;
        }

        public Model build() {
            return new Model(name, generation, fotoDirectory, carType);
        }
    }
}
