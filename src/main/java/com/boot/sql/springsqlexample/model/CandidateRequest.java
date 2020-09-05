package com.boot.sql.springsqlexample.model;

import lombok.Data;

@Data
public class CandidateRequest {
    String username;
    String password;
    String firstname;
    String lastname;
    Integer phone;
    String email;
    String gender;
    String city;
}
