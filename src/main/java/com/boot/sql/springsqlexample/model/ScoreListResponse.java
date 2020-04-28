package com.boot.sql.springsqlexample.model;

import lombok.Data;

import java.util.List;

@Data
public class ScoreListResponse {
    List<ScoreResponse> scoresList;
}
