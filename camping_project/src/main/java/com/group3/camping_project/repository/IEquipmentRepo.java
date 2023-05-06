package com.group3.camping_project.repository;

import com.group3.camping_project.entities.Equipment;
import com.group3.camping_project.entities.enums.EquipmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface IEquipmentRepo extends JpaRepository<Equipment,Long> {

    List<Equipment> findByEquipmentType(EquipmentType equipmentType);
}
