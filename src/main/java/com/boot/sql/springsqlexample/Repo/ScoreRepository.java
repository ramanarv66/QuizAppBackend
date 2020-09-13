package com.boot.sql.springsqlexample.Repo;

import com.boot.sql.springsqlexample.entity.ScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScoreRepository extends JpaRepository<ScoreEntity, Integer> {
    public Optional<ScoreEntity> findByEmail(String email);
}
