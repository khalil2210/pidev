package com.group3.camping_project.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Video implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] videoData;


}
