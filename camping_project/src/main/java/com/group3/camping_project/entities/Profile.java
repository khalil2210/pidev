package com.group3.camping_project.entities;

import com.group3.camping_project.entities.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profiles")
public class Profile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String bio;
    private String location;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToOne(mappedBy = "profile")
    private User user;

    @OneToOne
    private Image profileImage;

}
