package com.boot.sql.springsqlexample.Repo;

import com.boot.sql.springsqlexample.entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterEntityRepository extends JpaRepository<RegisterEntity, Integer> {
}
