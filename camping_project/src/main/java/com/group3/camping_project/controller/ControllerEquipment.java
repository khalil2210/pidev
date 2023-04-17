package com.group3.camping_project.controller;

import com.group3.camping_project.entities.Equipment;
import com.group3.camping_project.entities.EquipmentResponse;
import com.group3.camping_project.entities.Image;
import com.group3.camping_project.entities.User;
import com.group3.camping_project.repository.IEquipmentRepo;
import com.group3.camping_project.repository.IImageRepo;
import com.group3.camping_project.repository.IUserRepo;
import com.group3.camping_project.service.FileService.IImageService;
import com.group3.camping_project.service.ImpEquipe;

//import com.group3.camping_project.service.user_management.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Equipment")
public class ControllerEquipment {
    @Autowired
    public ImpEquipe impEquipe;
    @Autowired
    IEquipmentRepo iEquipmentRepo;
    @Autowired
    IImageRepo iImageRepo;
    @Autowired
    IImageService iImageService;

    @GetMapping("/getall")
    public List<Equipment> getaal(){
        return impEquipe.getallequip();
    }
    @GetMapping("one/{id}")
    public Equipment getoneEquipment(@PathVariable("id") Long id){
           return impEquipe.getoneEquipment(id);
    }
    @PostMapping("/addEquipment")
    public Equipment ajouterEquipment(@RequestBody Equipment equipment) {
        return impEquipe.addequipment(equipment);
    }
    @PostMapping("/addEquipment1/{id}")
    public Equipment ajouterEquipment1(@RequestBody Equipment equipment,@PathVariable("id") int id) {
        return impEquipe.addequipment1(equipment,id);
    }
    @PostMapping("/addEquipment2/{id}/{id1}")
    public Equipment ajouterEquipment2(@RequestBody Equipment equipment,@PathVariable("id") int id,@PathVariable("id1") int id1) {
        return impEquipe.addEquipment2(equipment,id,id1);
    }
    @PutMapping("/updateEquipment1/{id}")
    public Equipment updateEquipment1(@RequestBody Equipment equipment,@PathVariable("id") int id){
        return impEquipe.updateEquipment1(equipment,id);
    }
//    @PostMapping("/equipments")
//    public ResponseEntity<?> addEquipment(@RequestBody Equipment equipment, @RequestParam("image") MultipartFile imageFile) throws IOException {
//        String message =iImageService.saveImage(imageFile);
//        ByteArrayResource resource = new ByteArrayResource(message.getBytes());
//        equipment = impEquipe.addimage(equipment, (MultipartFile) resource);
//        return ResponseEntity.ok(equipment);
//    }

//    @PostMapping("/image")
//     public ResponseEntity<?> save(@RequestParam MultipartFile file,@RequestBody Equipment equipment) throws IOException {
//         String message =iImageService.saveImage(file);
//         Equipment equipment1 = impEquipe.addequipment(equipment);
//         EquipmentResponse response = new EquipmentResponse(equipment1, message);
//         return ResponseEntity.status(HttpStatus.OK).body(response);
//
//     }
//    @PostMapping("/addimage")
//    public ResponseEntity<Equipment> addEquipment(@RequestBody Equipment equipment) throws IOException {
//        Equipment savedEquipment = impEquipe.image(equipment);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedEquipment);
//    }


     @PutMapping("/updateEquipment")
    public Equipment updateEquipment(@RequestBody Equipment equipment){
        return impEquipe.updateEquipment(equipment);
     }
     @DeleteMapping("/delete/{id}")
    public void deleteEquipment(@PathVariable("id")Long id){
        impEquipe.deleteEquipement(id);
     }
//    @PostMapping("/equipment/{id}/image")
//    public ResponseEntity<Equipment> addImageToEquipment(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
//        Equipment equipment = impEquipe.findById(id);
//        Image image = new Image(file.getOriginalFilename(), file.getContentType(), file.getBytes());
//        equipment = impEquipe.addImageToEquipment(equipment, image);
//        return ResponseEntity.ok(equipment);
//    }
//    @PostMapping("/image")
//     public Equipment addimage(@RequestBody Equipment equipment, @RequestParam MultipartFile file ) throws IOException {
//        String message =iImageService.saveImage(file);
//        return  impEquipe.addEquipmentandimage(equipment,files);
//    }
}
