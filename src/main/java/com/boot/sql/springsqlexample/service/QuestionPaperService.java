package com.boot.sql.springsqlexample.service;

import com.boot.sql.springsqlexample.Repo.QuestionPaperRepository;
import com.boot.sql.springsqlexample.Repo.QuestionPaperRequestEntityRepo;
import com.boot.sql.springsqlexample.Repo.ScoreRepository;
import com.boot.sql.springsqlexample.entity.QuestionPaperRequestEntity;
import com.boot.sql.springsqlexample.entity.QuestionsPaperEntity;
import com.boot.sql.springsqlexample.entity.ScoreEntity;
import com.boot.sql.springsqlexample.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class QuestionPaperService {
    @Autowired
    QuestionPaperRepository questionPaperRepository;
    @Autowired
    QuestionPaperRequestEntityRepo questionPaperRequestEntityRepo;
    @Autowired
    ScoreRepository scoreRepository;

    public int save(QuestionPaperRequest paperRequest) {
        QuestionPaperRequestEntity questionPaperRequestEntity = new QuestionPaperRequestEntity();
        QuestionOptionsRequest questionsPaperEntity[] = new QuestionOptionsRequest[2];
        for (QuestionOptionsRequest questionOption : paperRequest.getQuestionOptions()) {

           // questionsPaperEntity.;
            questionsPaperEntity[0].setOptions(questionOption.getOptions());
            questionsPaperEntity[0].setQuestion(questionOption.getQuestion());

        }
       /* BeanUtils.copyProperties(paperRequest, questionPaperRequestEntity);
        questionPaperRequestEntity.getQuestionOptions()[0].toString();*/
        questionPaperRequestEntity.setQuestionOptions(questionsPaperEntity);
        System.out.println(questionPaperRequestEntity.getQuestionOptions()[0].toString());
        questionPaperRequestEntityRepo.save(questionPaperRequestEntity);
        return 1;

      /*  for (QuestionOptionsRequest questionOption : paperRequest.getQuestionOptions()) {
            QuestionsPaperEntity questionsPaperEntity = new QuestionsPaperEntity();
            questionsPaperEntity.setId(questionOption.getId());
            questionsPaperEntity.setOptions(questionOption.getOptions());
            questionsPaperEntity.setQuestion(questionOption.getQuestion());
        }
        return questionPaperRepository.save(questionsPaperEntity).getId();*/
    }

    public QuestionPaperResponse getQuestions() {
        QuestionPaperResponse questionPaperResponse = new QuestionPaperResponse();
        Iterable<QuestionsPaperEntity> allQuestionPapers = questionPaperRepository.findAll();
        allQuestionPapers.forEach(a -> {
            BeanUtils.copyProperties(a, questionPaperResponse);
        });
        return questionPaperResponse;
    }

    public int saveScore(ScoreRequest scoreRequest) {
        ScoreEntity scoreRequestEntity = new ScoreEntity();
        BeanUtils.copyProperties(scoreRequest, scoreRequestEntity);
        log.info("scoreRequestEntity ", scoreRequestEntity);
        return scoreRepository.save(scoreRequestEntity).getId();
    }

   /* public ScoreListResponse getScores() {
        List<ScoreEntity> scoreEntities = scoreRepository.findAll();
        List<ScoreResponse> scoreResponseList = new ArrayList<>();
        ScoreListResponse scoreListResponse = new ScoreListResponse();

        scoreEntities.forEach(a -> {
            ScoreResponse scoreResponse = new ScoreResponse();
            scoreResponse.setId(a.getId());
            scoreResponse.setEmail(a.getEmail());
            scoreResponse.setScore(a.getScore());
            scoreResponseList.add(scoreResponse);

        });
        scoreListResponse.setScoresList(scoreResponseList);

        return scoreListResponse;
    }*/
}
