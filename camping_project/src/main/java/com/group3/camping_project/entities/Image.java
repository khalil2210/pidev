package com.group3.camping_project.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Image implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @ManyToOne
//    private Equipment equipment;


    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] imageData;


    public Image(byte[] bytes) {
        this.imageData=bytes;
    }
}

