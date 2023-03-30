package com.group3.camping_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String content ;

    private Date sentAt ;

    @ManyToOne
    @JsonIgnore
    private Chatroom chatroom ;

    @ManyToOne
    private User sender ;

}
