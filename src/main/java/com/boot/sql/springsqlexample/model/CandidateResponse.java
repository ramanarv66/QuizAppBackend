package com.boot.sql.springsqlexample.model;

import lombok.Data;

@Data
public class CandidateResponse {
    String message;
    String username;
    String password;
    String firstname;
    String lastname;
    int phone;
    String email;
    String gender;
    String id;
    String city;
}
