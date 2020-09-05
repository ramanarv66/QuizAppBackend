package com.boot.sql.springsqlexample.model;

import com.boot.sql.springsqlexample.entity.RegisterEntity;
import lombok.Data;

import java.util.List;

@Data
public class CandidatesListResponse {
    List<RegisterEntity> candidateDtoList;
}
