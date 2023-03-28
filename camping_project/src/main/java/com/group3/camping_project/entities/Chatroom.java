package com.group3.camping_project.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Chatroom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id ;
    private String name;
    private Date lastUpdated;

    @OneToMany(mappedBy = "chatroom")
    private  List<Message> messages ;

    @ManyToOne
    private User owner ;


    @ManyToMany(mappedBy ="chatrooms" )
    private List<User> users;
}
