package com.boot.sql.springsqlexample.Repo;

import com.boot.sql.springsqlexample.entity.ScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<ScoreEntity, Integer> {
}
