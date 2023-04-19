package com.group3.camping_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

    @OneToOne
    private Image imageComment;
    @ManyToOne
    @JsonIgnore
    private Post post;

    @ManyToOne
    @JsonIgnore
    private User author;


}
