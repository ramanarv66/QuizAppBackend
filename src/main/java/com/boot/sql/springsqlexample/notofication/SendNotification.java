package com.boot.sql.springsqlexample.notofication;

import com.boot.sql.springsqlexample.model.CandidateRequest;
import com.boot.sql.springsqlexample.model.ScoreRequest;
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
		simpleMailMessage.setText(" Dear " + candidateRequest.getFirstname() + ",\n" +
						"Thanks for Registration, We confirm your Email: " + candidateRequest.getEmail() +
						" and Password: " + candidateRequest.getPassword()
				);
		javaMailSender.send(simpleMailMessage);
		
	}
	public void sendStatusAlerts(ScoreRequest scoreRequest) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(scoreRequest.getEmail());
		simpleMailMessage.setSubject("Written Test Status " );

		if(scoreRequest.getStatus().equalsIgnoreCase("excellent") || scoreRequest.getStatus().equalsIgnoreCase("good")
		|| scoreRequest.getStatus().equalsIgnoreCase("canTry")){
			simpleMailMessage.setText(" Dear " + scoreRequest.getFirstname() + ",\n" +
					"Thanks for taking test, You are Shortlisted and your Score is: " + scoreRequest.getScore() + "\nPlease Wait for HR!!!"
			);
		}else {
			simpleMailMessage.setText(" Dear " + scoreRequest.getFirstname() + ",\n" +
					"Thanks for taking test, We are sorry you are not shortlisted due to low: " + scoreRequest.getScore() + " Score \nBetter Luck Next Time!!!"
			);
		}
		javaMailSender.send(simpleMailMessage);

	}
	

}
