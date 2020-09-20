package com.boot.sql.springsqlexample.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SCORES")
public class ScoreEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  int id;
  String email;
  int score;
  String username;
  String password;
  String firstname;
  String lastname;
  String phone;
  String gender;
}
