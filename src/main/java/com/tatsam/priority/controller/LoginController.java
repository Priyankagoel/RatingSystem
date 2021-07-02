package com.tatsam.priority.controller;

import com.tatsam.priority.dto.UserData;
import com.tatsam.priority.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public String getToken(@RequestBody(required = true) final UserData userData) throws Exception{
        return userService.getTokenByUserNameAndPass(userData);
    }
}
