package com.group3.camping_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String content ;

    private LocalDateTime sentAt ;

    @ManyToOne
    @JsonIgnore
    private Chatroom chatroom ;

    @ManyToOne
    private User sender ;

    @OneToOne
    private Image image;

    @PrePersist
    public void setCreationDateTime() {
        this.sentAt = LocalDateTime.now();
    }

}
