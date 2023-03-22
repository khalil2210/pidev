package com.group3.camping_project.controller;

import com.group3.camping_project.entities.Equipment;
import com.group3.camping_project.service.ImpEquipe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/Equipment")
public class ControllerEquipment {

    public ImpEquipe impEquipe;
    @GetMapping("/getall")
    public List<Equipment> getaal(){
        return impEquipe.getallequip();
    }
    @GetMapping("one/{id}")
    public Equipment getoneEquipment(@PathVariable("id") Integer id){
           return impEquipe.getoneEquipment(id);
    }
    @PostMapping("/addEquipment")
    public Equipment ajouterEquipment(@RequestBody Equipment equipment){
        return impEquipe.ajouterEquipment(equipment);
    }
     @PutMapping("/updateEquipment")
    public Equipment updateEquipment(@RequestBody Equipment equipment){
        return impEquipe.updateEquipment(equipment);
     }
     @DeleteMapping("/delete/{id}")
    public void deleteEquipment(@PathVariable("id")Integer id){
        impEquipe.deleteEquipement(id);
     }
}
