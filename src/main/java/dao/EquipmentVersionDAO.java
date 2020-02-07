package dao;

import model.car.EquipmentVersion;

import java.util.List;

public interface EquipmentVersionDAO {
    void save(EquipmentVersion equipmentVersion);
    EquipmentVersion findByID(Integer ID);
    EquipmentVersion findPrimaryEquipmentVersion(EquipmentVersion equipmentVersion);
    List<EquipmentVersion> findByEquipmentName(String equipmentName);
    List<EquipmentVersion> findAll();
    List<EquipmentVersion> findByDescription(String description);
    Integer findID(EquipmentVersion equipmentVersion);
    void update(Integer id, EquipmentVersion equipmentVersion);
    void delete(Integer ID);
}
;