package com.group3.camping_project.entities;

import com.group3.camping_project.entities.enums.CampingType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GroupCamping implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String description;
    private String destination;
    private String carModel;
    private CampingType campingType;
    private Date createdAt ;
    private int AvailablePlaces ;
    private String requirements ;

  //  @ManyToOne
   // private User author;

  //  private List<User> goingUsers;

}
