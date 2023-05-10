package com.group3.camping_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.group3.camping_project.entities.enums.CampingType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GroupCamping implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @NotNull
    @Size(min = 2, max = 50)
    private String description;
    private String destination;
    private String carModel;
    private CampingType campingType;
    private Date createdAt ;
    private int AvailablePlaces ;
    private String requirements ;
    private int rating;
    @OneToOne(cascade =  CascadeType.ALL)
    private Image image;


    @ManyToOne
    private User owner;

    @ManyToMany
    @JsonIgnore
    private List<User> goingUsers;


}
