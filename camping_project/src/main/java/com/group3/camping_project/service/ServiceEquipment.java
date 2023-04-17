package com.group3.camping_project.service;

import com.group3.camping_project.entities.Equipment;
import com.group3.camping_project.entities.Image;
import com.group3.camping_project.entities.User;
import com.group3.camping_project.repository.IEquipmentRepo;
import com.group3.camping_project.repository.IImageRepo;
import com.group3.camping_project.repository.IUserRepo;
import com.group3.camping_project.service.FileService.IImageService;
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
//        user.getEquipment().add(equipment); // add equipment to user's list
//        iUserRepo.save(user); // save updated user entity
        return iEquipmentRepo.save(equipment);
    }
//  public Equipment ajouter(Equipment equipment, MultipartFile file) throws IOException {
////    Image image = new Image( file.getBytes());
////    Image savedImage = iImageRepo.save(image);
//
//    Equipment savedEquipment = iEquipmentRepo.save(equipment);
//    return savedEquipment;
//}
//    public Equipment addimage(Equipment equipment,MultipartFile file) {
//        List<Image> imageDataList = equipment.getImages();
//        // Save the images and set the equipment reference
//        List<Image> images = new ArrayList<>();
//        for (Image imageData : imageDataList) {
//            Image image = new Image();
//            image.setImageData(imageData.getImageData());
//            image.setEquipment(equipment);
//            images.add(image);
//        }
//        equipment.setImages(images);
//        iEquipmentRepo.save(equipment);
//
//        return equipment;
//    }
//public Equipment addEquipmentandimage(Equipment equipment, MultipartFile file) throws IOException {
//
//    equipment = iEquipmentRepo.save(equipment);
//
//    // Save the images and set the equipment reference
//
//
//        String fileName = file.getOriginalFilename();
//        byte[] imageData = file.getBytes();
//        String contentType = file.getContentType();
//        long size = file.getSize();
//
//        // Save the image using the ImageService
//        String message = iImageService.saveImage(file);
//        if (message == null) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to save image");
//        }
//
//        // Create a new Image object and add it to the list
//        Image image = new Image();
//
//        image.setImageData(imageData);
//
//
//
//    equipment.setImage(image);
//
//    return equipment;
//}
//@Override
//public Equipment image(Equipment equipment) throws IOException {
//    // Save the equipment
//    Equipment savedEquipment = iEquipmentRepo.save(equipment);
//
//    // Save the images and set the equipment reference
//    List<Image> imageDataList = equipment.getImages();
//    List<String> images = new ArrayList<>();
//    for (Image imageData : imageDataList) {
//        Image image = new Image();
//        image.setImageData(imageData.getImageData());
//        image.setEquipment(savedEquipment);
//        images.add(iImageService.saveImage((MultipartFile) image));
//    }
//    List<Image> all=convertStringsToImages(images);
//    savedEquipment.setImages(all);
//
//    return savedEquipment;
//}
//    public List<Image> convertStringsToImages(List<String> imageDataList) {
//        List<Image> images = new ArrayList<>();
//        for (String imageData : imageDataList) {
//            Image image = new Image();
//            image.setImageData(imageData.getBytes());
//            images.add(image);
//        }
//        return images;
//    }

}
