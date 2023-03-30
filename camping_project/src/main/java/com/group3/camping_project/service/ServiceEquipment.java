package com.group3.camping_project.service;

import com.group3.camping_project.entities.Equipment;
import com.group3.camping_project.entities.Image;
import com.group3.camping_project.repository.IEquipmentRepo;
import com.group3.camping_project.repository.IImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class ServiceEquipment implements ImpEquipe {
    @Autowired
    IEquipmentRepo iEquipmentRepo;
    @Autowired
    IImageRepo iImageRepo;
    @Override
    public Equipment addequipment(Equipment equipment)  {
        return iEquipmentRepo.save(equipment);
    }


    @Override
    public List<Equipment> getallequip() {
        return iEquipmentRepo.findAll();
    }

    @Override
    public Equipment getoneEquipment(long id) {
        return iEquipmentRepo.findById(id).get();
    }

    @Override
    public Equipment updateEquipment(Equipment equipment) {
        return iEquipmentRepo.save(equipment);
    }

    @Override
    public void deleteEquipement(long id) {
          iEquipmentRepo.deleteById(id);
    }
}
