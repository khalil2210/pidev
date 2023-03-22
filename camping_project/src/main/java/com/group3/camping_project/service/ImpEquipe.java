package com.group3.camping_project.service;

import com.group3.camping_project.entities.Equipment;

import java.util.List;

public interface ImpEquipe {
     Equipment  ajouterEquipment(Equipment equipment);
    List<Equipment> getallequip();
     Equipment getoneEquipment(int id);
     Equipment updateEquipment(Equipment equipment);
    void deleteEquipement(int id);
}
