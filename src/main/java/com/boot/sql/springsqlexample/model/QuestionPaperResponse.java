package com.boot.sql.springsqlexample.model;

import lombok.Data;

@Data
public class QuestionPaperResponse {
  String questionPaperContent;
  int versionId;
  String uploadedBy;
}
