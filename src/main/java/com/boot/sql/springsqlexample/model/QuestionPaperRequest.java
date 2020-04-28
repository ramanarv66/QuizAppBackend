package com.boot.sql.springsqlexample.model;

import lombok.Data;

@Data
public class QuestionPaperRequest {
//  String questionPaperContent;
//  int versionId;
//  String uploadedBy;
  QuestionOptionsRequest questionOptions[];
}
