package com.boot.sql.springsqlexample.contoller;

import com.boot.sql.springsqlexample.model.UserInfoResponse;
import com.boot.sql.springsqlexample.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//@RestController
//@RequestMapping("userinfo")
//public class UserInfoController {
//
//    @Autowired
//    UserInfoService userInfoService;
//    @GetMapping("/users")
//    public List<UserInfoResponse> getAllUsers(){
//
//        return  userInfoService.getAllUsers();
//
//    }
//}
