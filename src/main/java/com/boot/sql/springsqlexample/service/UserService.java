package com.boot.sql.springsqlexample.service;

import java.util.List;

import com.boot.sql.springsqlexample.model.CandidateRequest;
import com.boot.sql.springsqlexample.model.CandidateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.sql.springsqlexample.dao.UserDao;
import com.boot.sql.springsqlexample.exception.CustomerNotFoundException;
import com.boot.sql.springsqlexample.model.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public String validateUser(User user) {
		String validateString="";
		try {
		User user1 =  userDao.validateUser(user);
		if(user.getUsername().equals(user1.getUsername())) {
			validateString=  "Validated";
		}
		}catch(CustomerNotFoundException ces) {
			throw new CustomerNotFoundException("No CusotmerFound With " + user.getEmail()+"email");
		}
		
		return validateString;
	}
	public String validateCandidate(CandidateRequest candidateRequest) {
		String validateString="";
		try {
			CandidateResponse candidateResponse =  userDao.validateCandidate(candidateRequest);
			if(candidateResponse.getUsername().equals(candidateRequest.getUsername())) {
				validateString=  "Validated";
			}
		}catch(CustomerNotFoundException ces) {
			throw new CustomerNotFoundException("No CusotmerFound With " + candidateRequest.getEmail()+"email");
		}

		return validateString;
	}

	public String register(User user) {
		// TODO Auto-generated method stub
		return userDao.registerUser(user);
	}
	
	public String editUser(User user, String email) {
		
		return userDao.editUser(user, email);
	}
	
	public String deleteEmployee(String userName) {
		return userDao.delete(userName);
	}
	
	 public List <User> findAll() {
	        return userDao.findAll();
	    }
	

}
