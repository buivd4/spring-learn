package com.prdcv.learnspring.rest;

import com.prdcv.learnspring.domain.User;
import com.prdcv.learnspring.repository.UserRepository;
import com.prdcv.learnspring.rest.dto.UserResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserManagerRest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper pojoMapper;

    @GetMapping(path = "/users")
    public List<UserResponseDto> getAllUser(){
        List<UserResponseDto> userDto= new ArrayList<>();
        userRepository.findAll().forEach(
                user -> userDto.add(pojoMapper.map(user,UserResponseDto.class))
        );
        return userDto;
    }
    @PostMapping(path = "/users")
    public UserResponseDto createUser(@RequestBody User newUser){
        return pojoMapper.map(userRepository.save(newUser),UserResponseDto.class);
    }
}
