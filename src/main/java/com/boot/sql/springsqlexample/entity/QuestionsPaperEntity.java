package com.boot.sql.springsqlexample.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "QUESTION_PAPER")
public class QuestionsPaperEntity {
  @Id
  @GeneratedValue
  int id;
  @Column(length = 5000)
  String question;
  String options [];

}
