package com.group3.camping_project.service;

import com.group3.camping_project.entities.Equipment;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImpEquipe {
    public Equipment addequipment(Equipment equipment);
    List<Equipment> getallequip();
     Equipment getoneEquipment(long id);
     Equipment updateEquipment(Equipment equipment);
    void deleteEquipement(long id);
}
