package com.boot.sql.springsqlexample.Repo;

import com.boot.sql.springsqlexample.entity.RegisterEntity;
import com.boot.sql.springsqlexample.entity.RegisterEntityResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterEntityRepository extends JpaRepository<RegisterEntity, Integer> {
    public RegisterEntity findByEmail(String email);
}
