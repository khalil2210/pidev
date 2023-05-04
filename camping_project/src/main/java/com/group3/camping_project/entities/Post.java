package com.group3.camping_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.beans.MutablePropertyValues;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
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

   private String Likes;



    @ManyToOne
    @JsonIgnore
    private User author ;

    @OneToOne
    private Image image;

    @OneToOne
    private Video video;

    @OneToMany(mappedBy = "post")
    @JsonIgnore
    private List<Comment> comment;



}
