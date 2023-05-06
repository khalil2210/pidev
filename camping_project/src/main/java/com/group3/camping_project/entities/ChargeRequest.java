package com.group3.camping_project.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class ChargeRequest implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String cardNumber;
    private String exp_month;
    private String exp_year;
    private String phone;
    private String cvv;
    private Long amount;
    private String currency;
    private String customer;
    private String description;
    private String token;
    private String postal_code;
    private int total;


}
