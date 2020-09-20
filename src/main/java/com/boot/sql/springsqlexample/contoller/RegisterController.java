package com.boot.sql.springsqlexample.contoller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.boot.sql.springsqlexample.Repo.RegisterEntityRepository;
import com.boot.sql.springsqlexample.Repo.ScoreRepository;
import com.boot.sql.springsqlexample.entity.RegisterEntity;
import com.boot.sql.springsqlexample.entity.RegisterEntityResponse;
import com.boot.sql.springsqlexample.entity.ScoreEntity;
import com.boot.sql.springsqlexample.model.*;
import com.boot.sql.springsqlexample.notofication.SendNotification;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.boot.sql.springsqlexample.service.UserService;
@CrossOrigin("*")
@RestController
public class RegisterController {
	
	@Autowired
	UserService userService;
	@Autowired
	HttpServletRequest request;
	@Autowired
	RegisterEntityRepository registerEntityRepository;
	@Autowired
	SendNotification sendNotification;
	@Autowired
	ScoreRepository scoreRepository;

	@PostMapping("/regCand")
	public CandidateResponse registerCandidate(@RequestBody CandidateRequest candidateRequest){
		CandidateResponse response = new CandidateResponse();
		RegisterEntity registerEntity = new RegisterEntity();
		BeanUtils.copyProperties(candidateRequest, registerEntity);
		registerEntity=  registerEntityRepository.save(registerEntity);
		Optional<RegisterEntity> rr = registerEntityRepository.findById(registerEntity.getId());
		if(rr.get().getId() > 0){
			response.setMessage("Success");
			// sendNotification.sendAlerts(candidateRequest);
		}
		return response;
	}
	@GetMapping("/getCandidatesList")
	public CandidatesListResponse getCandidatesList(){
		CandidatesListResponse candidatesListResponse = new CandidatesListResponse();
		List<RegisterEntity>  list =  registerEntityRepository.findAll();
		BeanUtils.copyProperties(list,candidatesListResponse);
		candidatesListResponse.setCandidateDtoList(list);
		System.out.println(candidatesListResponse);
		return  candidatesListResponse;
	}
	@GetMapping("/getScores")
	public ScoreListResponse getScores(){
		ScoreListResponse scoreListResponse = new ScoreListResponse();
		List<ScoreEntity>  list =  scoreRepository.findAll();
		BeanUtils.copyProperties(list,scoreListResponse);
		scoreListResponse.setScoresList(list);
		return  scoreListResponse;
	}
	@GetMapping("/test")
	public String testMethod() {
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getLocalAddr());
		System.out.println(request.getHeader("X-FORWARDED-FOR"));
		return "Hello Ramana!!!";
	}
	@PostMapping("/saveScore")
	public ScoreResponse saveScore(@RequestBody ScoreRequest scoreRequest){
		ScoreResponse scoreResponse = new ScoreResponse();
		 ScoreEntity scoreEntity = new ScoreEntity();
		// BeanUtils.copyProperties(scoreRequest,scoreEntity);
		RegisterEntity ed = registerEntityRepository.findByEmail(scoreRequest.getEmail());
		BeanUtils.copyProperties(ed,scoreEntity);
		scoreEntity.setScore(scoreRequest.getScore());
		// Optional<ScoreEntity> scoreEntity1 = scoreRepository.findById(scoreEntity.getId());
		scoreRepository.save(scoreEntity);
		Optional<ScoreEntity> scoreEntity1 = scoreRepository.findByEmail(ed.getEmail());
		if (scoreEntity1.get().getId() > 0){
			scoreResponse.setMessage("Success");
		}
		return scoreResponse;
	}

	@PostMapping("/validate")
	public CandidateResponse  validate(@RequestBody CandidateRequest candidateRequest){
		CandidateResponse candidateResponse = new CandidateResponse();
		RegisterEntity registerEntity = new RegisterEntity();
		BeanUtils.copyProperties(candidateRequest, registerEntity);
		RegisterEntity ed = registerEntityRepository.findByEmail(candidateRequest.getEmail());
		if(ed.getId() >0){
			candidateResponse.setMessage("validuser");
		}
		return candidateResponse;
	}

	@PostMapping("/sendStatus")
	public void sendStatus(@RequestBody ScoreRequest ScoreRequest){
		sendNotification.sendStatusAlerts(ScoreRequest);
	}
}
