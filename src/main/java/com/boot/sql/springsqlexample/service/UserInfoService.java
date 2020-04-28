package com.boot.sql.springsqlexample.service;

import com.boot.sql.springsqlexample.model.UserInfoResponse;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//@FeignClient(name = "userinfoservice", url = "https://jsonplaceholder.typicode.com")
public interface UserInfoService {
    @GetMapping("/posts")
    public List<UserInfoResponse> getAllUsers();
}
