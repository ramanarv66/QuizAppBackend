package com.boot.sql.springsqlexample.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import lombok.Data;

@Data
@Api(value = "Score request Object")
public class ScoreRequest {
  @ApiModelProperty(notes = "candidate email id", value = "m.ramana@outlook.com")
  String email;
  int score;
}
