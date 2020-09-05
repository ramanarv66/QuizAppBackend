package com.boot.sql.springsqlexample.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Candidate")
public class RegisterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String username;
    String password;
    String firstname;
    String lastname;
    Integer phone;
    String email;
    String gender;
    String city;
}
