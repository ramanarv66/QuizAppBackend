package com.boot.sql.springsqlexample.contoller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.boot.sql.springsqlexample.Repo.RegisterEntityRepository;
import com.boot.sql.springsqlexample.entity.RegisterEntity;
import com.boot.sql.springsqlexample.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping("/regCand")
	public CandidateResponse registerCandidate(@RequestBody CandidateRequest candidateRequest){
		CandidateResponse response = new CandidateResponse();
		RegisterEntity registerEntity = new RegisterEntity();
		BeanUtils.copyProperties(candidateRequest, registerEntity);
		registerEntity=  registerEntityRepository.save(registerEntity);
		Optional<RegisterEntity> rr = registerEntityRepository.findById(registerEntity.getId());
		if(rr.get().getId() > 0){
			response.setMessage("Success");
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
	@GetMapping("/test")
	public String testMethod() {
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getLocalAddr());
		System.out.println(request.getHeader("X-FORWARDED-FOR"));
		return "Hello Ramana!!!";
	}
	@PostMapping("/validate")
	public UserResponse validate(@RequestBody User user) {
		UserResponse response = new UserResponse();
		String resp = userService.validateUser(user);
		response.setResponse(resp);
		return response;
	}
	@PostMapping("/authenticate")
	public UserResponse authenticate(@RequestBody User user) {
		System.out.println(request.getRemoteAddr());
		UserResponse response = new UserResponse();
		response.setResponse(userService.validateUser(user));
		return response;
	}
	@PostMapping("/register")
	public UserResponse register(@RequestBody User user) {
		UserResponse response = new UserResponse();
		response.setResponse(userService.register(user));
		return response;
	}
	@PutMapping("/update/{email}")
	public UserResponse updateUser(@RequestBody User user,@PathVariable String email) {
		UserResponse response = new UserResponse();
		response.setResponse(userService.editUser(user,email));
		return response;
	}
	@GetMapping(value="/getEmployees")
	public List<User> getUsers() {
		List<User> userList = new ArrayList();
		userList = userService.findAll();
		return userList;
	}
	@DeleteMapping(value="/delete/{username}")
	public UserResponse delete(@PathVariable String username) {
		UserResponse response = new UserResponse();

		response.setResponse(userService.deleteEmployee(username));
		return response;
	}

}
