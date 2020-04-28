package com.boot.sql.springsqlexample.Repo;

import com.boot.sql.springsqlexample.entity.QuestionsPaperEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface QuestionPaperRepository extends CrudRepository<QuestionsPaperEntity, Integer> {

}
