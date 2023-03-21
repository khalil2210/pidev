package com.group3.camping_project.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Review implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String content ;
    private int rating ;
    private Date createdAt ;


    @ManyToOne
    private CampingSpace campingSpace;
}
