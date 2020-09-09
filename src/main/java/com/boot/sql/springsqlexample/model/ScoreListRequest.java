package com.boot.sql.springsqlexample.model;

import lombok.Data;

@Data
public class ScoreListRequest {
    int id;
    String email;
    int score;
}
