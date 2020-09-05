package com.boot.sql.springsqlexample.notofication;

import com.boot.sql.springsqlexample.model.CandidateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendNotification {
	
	
	private JavaMailSender javaMailSender;
	public SendNotification(@Autowired JavaMailSender javaMailSender){
		this.javaMailSender=javaMailSender;
	}
	
	
	public void sendAlerts(CandidateRequest candidateRequest) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(candidateRequest.getEmail());
		simpleMailMessage.setSubject("Registration Successful " + candidateRequest.getFirstname() + " " + candidateRequest.getLastname());
		simpleMailMessage.setText("Dear " + candidateRequest.getFirstname() + " \n " +
						"Thanks for Registration, We confirm your Username: " + candidateRequest.getUsername() +
				" and Password: " + candidateRequest.getPassword()
				);
		javaMailSender.send(simpleMailMessage);
		
	}
	

}
