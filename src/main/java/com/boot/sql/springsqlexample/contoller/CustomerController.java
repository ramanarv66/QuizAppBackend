package com.boot.sql.springsqlexample.contoller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.sql.springsqlexample.model.User;
import com.boot.sql.springsqlexample.model.UserResponse;
import com.boot.sql.springsqlexample.service.UserService;
@CrossOrigin("*")
@RestController
public class CustomerController {
	
	@Autowired
	UserService userService;
	@Autowired
	HttpServletRequest request;
	
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
