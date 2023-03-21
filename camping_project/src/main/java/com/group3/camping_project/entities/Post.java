package com.group3.camping_project.entities;

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
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title ;

    private String  content ;

    private int LikesNumber ;

    private Date creationDate;

    private Date updateDate;


 /*   @ManyToOne
    private User user ;
    @OneToMany
    private List<Image> image;

    @OneToMany
    private List<Video> video;


    @OneToMany(mappedBy = "post")
    private List<Comment> comment;
    */
}
