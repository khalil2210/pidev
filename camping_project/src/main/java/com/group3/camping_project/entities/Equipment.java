package com.group3.camping_project.entities;

import com.group3.camping_project.entities.enums.EquipmentType;
import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


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
   private int quantite_payment;
   private String description;
   private float price;
   private int rate;
    @Column(updatable = false)
   private LocalDateTime createdAt ;
    private LocalDateTime updatetime ;
    private int likeii ;

    private int quantity ;


   @Enumerated(EnumType.STRING)
   private EquipmentType equipmentType ;

    @ManyToOne

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
