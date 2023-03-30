package com.group3.camping_project.entities;

import com.group3.camping_project.entities.enums.EquipmentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Equipment implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id ;

   private String name;

   private String description;
   private float price;

   private LocalDateTime createdAt ;

   private int quantity ;


   @Enumerated(EnumType.STRING)
   private EquipmentType equipmentType ;

   @ManyToOne
   private User user;

   @OneToOne
   private Image image ;



   @PrePersist
   public void a(){
      createdAt = LocalDateTime.now();
   }

}
