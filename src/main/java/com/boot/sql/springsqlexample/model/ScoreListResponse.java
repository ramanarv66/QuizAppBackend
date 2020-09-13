package com.boot.sql.springsqlexample.model;

import com.boot.sql.springsqlexample.entity.ScoreEntity;
import lombok.Data;

import java.util.List;

@Data
public class ScoreListResponse {
    List<ScoreEntity> scoresList;
}
