package com.group3.camping_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String content ;
    private Date createdAt ;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Image image;
    @ManyToOne
    @JsonIgnore
    private Post post;
    @JsonIgnore
    @OneToMany(mappedBy = "comment")
    List<LikeDislikeComment> likeDislikeComments;
    @ManyToOne
    private User author;


}
