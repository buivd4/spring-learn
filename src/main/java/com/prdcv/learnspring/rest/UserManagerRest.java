package com.prdcv.learnspring.rest;

import com.prdcv.learnspring.dto.UserResponseDto;
import com.prdcv.learnspring.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserManagerRest {
    @Autowired
    private UserService userService;
    @GetMapping(path = "/users")
    public List<UserResponseDto<?>> getAllUser(){
        return userService.getAll();
    }
}
