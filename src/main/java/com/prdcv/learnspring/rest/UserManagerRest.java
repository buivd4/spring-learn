package com.prdcv.learnspring.rest;

import com.prdcv.learnspring.domain.User;
import com.prdcv.learnspring.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserManagerRest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper pojoMapper;

    @GetMapping(path = "/users")
    public List<User> getAllUser(){
        return
    }
}
