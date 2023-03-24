package com.group3.camping_project.entities;

import com.group3.camping_project.entities.enums.Gender;
import com.group3.camping_project.entities.enums.Role;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    private String phoneNumber;


    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    private Date updateDate;

    @OneToOne
    private Image profileImage;

    @OneToMany(mappedBy = "author")
    private List<Post> posts;

    @ManyToMany
    private List<CampingSpace> createdCampingSpace;

    @OneToMany(mappedBy = "owner")
    private List<Equipment> equipment;

    @ManyToMany(mappedBy = "goingUsers")
    private List<GroupCamping> groupCamping;

    @OneToMany(mappedBy = "owner")
    private List<GroupCamping> createdGroupCamping  ;


    @OneToMany(mappedBy = "owner")
    private List<Chatroom>chatroomCreated;
    @ManyToMany
    private List<Chatroom>chatrooms;


    @OneToMany(mappedBy = "author")
    private List<Comment> comments;


    @OneToMany(mappedBy = "author")
    private List<Review> campingSpaceReview;

    @OneToMany(mappedBy = "sender")
    private List<Message>messages;



}
