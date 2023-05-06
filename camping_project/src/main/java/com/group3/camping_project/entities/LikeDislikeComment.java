package com.group3.camping_project.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.group3.camping_project.entities.enums.CommentRate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LikeDislikeComment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    CommentRate commentRate;
    @ManyToOne
    @JsonIgnore
    User user;
    @ManyToOne
    @JsonIgnore
    Comment comment;

}
