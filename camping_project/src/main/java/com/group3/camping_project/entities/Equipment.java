package com.group3.camping_project.entities;

import com.group3.camping_project.entities.enums.EquipmentType;
import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Equipment implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id ;

   private String name;
   private int like;
   private String description;
   private float price;
    @Column(updatable = false)
   private LocalDateTime createdAt ;
    private LocalDateTime updatetime ;

   private int quantity ;


   @Enumerated(EnumType.STRING)
   private EquipmentType equipmentType ;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private Image image;

    @PrePersist
    public void create(){
        createdAt = LocalDateTime.now();

    }
    @PreUpdate
   public void a(){

        updatetime = LocalDateTime.now();
   }

}
