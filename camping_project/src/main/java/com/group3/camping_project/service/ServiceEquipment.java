package com.group3.camping_project.service;

import com.group3.camping_project.entities.Equipment;
import com.group3.camping_project.repository.IEquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceEquipment implements ImpEquipe {
    @Autowired
    public IEquipmentRepo iEquipmentRepo;
    @Override
    public Equipment ajouterEquipment(Equipment equipment) {
        return iEquipmentRepo.save(equipment);
    }

    @Override
    public List<Equipment> getallequip() {
        return iEquipmentRepo.findAll();
    }

    @Override
    public Equipment getoneEquipment(int id) {
        return iEquipmentRepo.findById(id).get();
    }

    @Override
    public Equipment updateEquipment(Equipment equipment) {
        return iEquipmentRepo.save(equipment);
    }

    @Override
    public void deleteEquipement(int id) {
          iEquipmentRepo.deleteById(id);
    }
}
