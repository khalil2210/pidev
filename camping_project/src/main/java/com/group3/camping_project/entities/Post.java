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
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title ;

    private String  content ;

    private int LikesNumber ;

    private Date creationDate;

    private Date updateDate;

    @ManyToOne
    private User author ;

    @OneToOne
    private Image image;

    @OneToOne
    private Video video;

    @OneToMany(mappedBy = "post")
    private List<Comment> comment;
}
