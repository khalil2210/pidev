package com.group3.camping_project.service.equipement_service;

import com.group3.camping_project.entities.Equipment;
import com.group3.camping_project.entities.enums.EquipmentType;

import java.util.List;

public interface ImpEquipe {
     Equipment addequipment(Equipment equipment);
    List<Equipment> getallequip();
     Equipment getoneEquipment(long id);
     Equipment updateEquipment(Equipment equipment);
    void deleteEquipement(long id);
    Equipment addequipment1(Equipment equipment,int id);
    Equipment updateEquipment1(Equipment equipment,int id);
    List<Equipment> findbytype(EquipmentType equipmentType);

    Equipment addEquipment2(Equipment equipment, int idimg, int iduser);

}
