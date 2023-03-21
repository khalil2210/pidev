package com.group3.camping_project.entities;

import com.group3.camping_project.entities.enums.Gender;
import com.group3.camping_project.entities.enums.Role;
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
public class User implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName ;
    private String lastName;
    private String email;
    private String password;
    private int phoneNumber;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    private Date creationDate;

    private Date updateDate;




/*
    @OneToOne
    private Image profileImage;

    @ManyToMany(mappedBy = "user")
    private List<CampingSpace> campingSpace;
    @OneToMany(mappedBy = "user")
    private List<Equipment> equipment;
    @OneToMany(mappedBy = "user")
    private List<GroupCamping> groupCampings;
    @ManyToMany(mappedBy = "users")
    private List<Chatroom> chatrooms;
    @OneToMany(mappedBy = "users")
    private  List<Comment>  comments;
    @OneToMany(mappedBy = "user")
    private List<Post> posts;
    @OneToMany(mappedBy = "user")
    private List<Reviews> reviews ;*/
}
