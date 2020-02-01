package model.car;

import javax.persistence.*;

@Entity
@Table(name = "equipment_version")
public class EquipmentVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_value_ID")
    private Integer equipmentVersionID;
    @Column(name = "equipment_name", nullable = false)
    private String equipmentName;
    @Column(name = "description", nullable = false)
    private String equipmentDescription;


    public EquipmentVersion(String equipmentName, String equipmentDescription) {
        this.equipmentName = equipmentName;
        this.equipmentDescription = equipmentDescription;
    }

    public Integer getEquipmentVersionID() {
        return equipmentVersionID;
    }

    public void setEquipmentVersionID(Integer equipmentVersionID) {
        this.equipmentVersionID = equipmentVersionID;
    }

    public String getEquipmentDescription() {
        return equipmentDescription;
    }

    public void setEquipmentDescription(String equipment_description) {
        this.equipmentDescription = equipment_description;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipment_name) {
        this.equipmentName = equipment_name;
    }

}