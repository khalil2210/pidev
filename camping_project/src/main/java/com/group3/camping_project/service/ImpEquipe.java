package com.group3.camping_project.service;

import com.group3.camping_project.entities.Equipment;
import com.group3.camping_project.entities.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImpEquipe {
     Equipment addequipment(Equipment equipment);
    List<Equipment> getallequip();
     Equipment getoneEquipment(long id);
     Equipment updateEquipment(Equipment equipment);
    void deleteEquipement(long id);
    Equipment addequipment1(Equipment equipment,int id);
    Equipment updateEquipment1(Equipment equipment,int id);


    Equipment addEquipment2(Equipment equipment, int idimg, int iduser);
//    Equipment saveEquipmentWithUserAndImage(Equipment equipment, MultipartFile imageFile) throws IOException;
//     Equipment addImageToEquipment(Equipment equipment, Image image);
//Equipment addEquipmentandimage(Equipment equipment, MultipartFile files) throws IOException;
    //Equipment addimage(Equipment equipment,MultipartFile file);
    //Equipment image(Equipment equipment) throws IOException;
}
