package com.boot.sql.springsqlexample.Repo;

import com.boot.sql.springsqlexample.entity.QuestionPaperRequestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionPaperRequestEntityRepo extends CrudRepository<QuestionPaperRequestEntity, Integer> {
}
