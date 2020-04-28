package com.boot.sql.springsqlexample.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class QuestionOptionsRequest implements Serializable {
  String question;
  String options [];
  int id;
}
