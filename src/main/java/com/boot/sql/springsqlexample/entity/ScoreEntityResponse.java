package com.boot.sql.springsqlexample.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "SCORES")
public class ScoreEntityResponse {
  @Id
  @GeneratedValue
  int id;
  String email;
  int score;

}
