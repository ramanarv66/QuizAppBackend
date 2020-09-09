package com.boot.sql.springsqlexample.contoller;

import com.boot.sql.springsqlexample.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.sql.springsqlexample.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("user")
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;

	/*
	 * @PostMapping("/authenticate") public String authenticate(@RequestBody User
	 * user) { logger.info("In Usercontroller" + user); return
	 * userService.validateUser(user); }
	 */
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	/*public ResponseEntity<?> authenticate(@RequestBody User user) throws Exception {

		
		 * authenticate(authenticationRequest.getUsername(),
		 * authenticationRequest.getPassword());
		 * 
		 * final UserDetails userDetails =
		 * userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		 
		final String token = userService.validateUser(user);

		return ResponseEntity.ok(new JwtResponse(token));
	}*/
	public UserResponse validateUser(@RequestBody User user) {
		UserResponse userResponse = new UserResponse();
		userResponse.setResponse(userService.validateUser(user));
		return userResponse;
	}

	@RequestMapping(value = "/validateCand", method = RequestMethod.POST)
	public CandidateResponse validateCandidate(@RequestBody CandidateRequest candidateRequest) {
		CandidateResponse candidateResponse = new CandidateResponse();
		candidateResponse.setMessage(userService.validateCandidate(candidateRequest));
		return candidateResponse;
	}
}
