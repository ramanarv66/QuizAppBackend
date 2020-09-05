package com.boot.sql.springsqlexample.contoller;

import com.boot.sql.springsqlexample.model.CandidateRequest;
import com.boot.sql.springsqlexample.notofication.SendNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@CrossOrigin("*")
public class EmailController {

    @Autowired
    SendNotification sendNotification;

    @PostMapping("/send")
    public void sendEmail(@RequestBody CandidateRequest candidateRequest){
        this.sendNotification.sendAlerts(candidateRequest);

    }
}
