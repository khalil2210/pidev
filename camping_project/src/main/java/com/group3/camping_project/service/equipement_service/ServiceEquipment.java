package com.group3.camping_project.service.equipement_service;

import com.group3.camping_project.entities.Equipment;
import com.group3.camping_project.entities.Image;
import com.group3.camping_project.entities.User;
import com.group3.camping_project.entities.enums.EquipmentType;
import com.group3.camping_project.repository.IEquipmentRepo;
import com.group3.camping_project.repository.IImageRepo;
import com.group3.camping_project.repository.IUserRepo;
import com.group3.camping_project.service.file_service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceEquipment implements ImpEquipe {
    @Autowired
    IEquipmentRepo iEquipmentRepo;
    @Autowired
    IImageService iImageService;
    @Autowired
     IImageRepo iImageRepo;
    @Autowired
    IUserRepo iUserRepo;


    @Override
    public Equipment addequipment(Equipment equipment) {
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
    @Override
    public Equipment addequipment1(Equipment equipment,int id) {
        Image image= iImageRepo.findById(id).get();
        equipment.setImage(image);
        return iEquipmentRepo.save(equipment);
    }
    @Override
    public List<Equipment> findbytype(EquipmentType equipmentType) {
        List<Equipment> equipment=iEquipmentRepo.findByEquipmentType(equipmentType);
        for (Equipment equipment1 : equipment
        ){
            iEquipmentRepo.save(equipment1);       }
        return equipment;

    }
    @Override
    public Equipment updateEquipment1(Equipment equipment,int id) {
        Image image= iImageRepo.findById(id).get();
        equipment.setImage(image);
        System.out.println(equipment);
        return iEquipmentRepo.save(equipment);
    }
    @Override
    public Equipment addEquipment2(Equipment equipment, int idimg, int iduser) {
        Image image= iImageRepo.findById(idimg).get();
        User user = iUserRepo.findById(iduser).get();
        System.out.println(user);
        equipment.setImage(image);
        equipment.setUser(user);
        return iEquipmentRepo.save(equipment);
    }


}
