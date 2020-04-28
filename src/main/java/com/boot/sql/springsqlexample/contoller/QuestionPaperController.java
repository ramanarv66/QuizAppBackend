package com.boot.sql.springsqlexample.contoller;


import com.boot.sql.springsqlexample.model.*;
import com.boot.sql.springsqlexample.service.QuestionPaperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/upload")
@CrossOrigin("*")
@Api(value = "API for Question paper", produces = "Single API for different Question paper endpoints")
@Data
public class QuestionPaperController {

  @Autowired
  QuestionPaperService questionPaperService;
  /*@PostMapping("save-questions")
  public boolean saveQuestionPaper(@RequestBody QuestionPaperRequest questionPaperRequest){
     int isSaved =  questionPaperService.save(questionPaperRequest);
    return  isSaved > 0 ? true : false;
  }*/
  @ApiOperation(value = "Get Questions from DB", notes = "Get Questions")
  @GetMapping("get-questions")
  public QuestionPaperResponse getQuestions(){
    QuestionPaperResponse questionPaperResponse = new QuestionPaperResponse();
    questionPaperResponse = questionPaperService.getQuestions();
    return  questionPaperResponse;

  }
  @PostMapping("save-answers")
  public boolean saveScore(@RequestBody ScoreRequest scoreRequest){
    int isSaved = questionPaperService.saveScore(scoreRequest);
    return isSaved > 0 ? true:false;
  }
  @GetMapping("scores")
  public ScoreListResponse getScore(){
    return questionPaperService.getScores();
  }
}
