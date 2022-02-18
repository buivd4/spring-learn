package com.prdcv.learnspring.service.impl;

import com.prdcv.learnspring.repository.UserRepository;
import com.prdcv.learnspring.dto.UserResponseDto;
import com.prdcv.learnspring.service.facade.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class UserServiceImpl implements UserService {
    private static class UserResponseDtoStr extends UserResponseDto<String>{};
    private static class UserResponseDtoNumber extends UserResponseDto<Integer>{};
    private static class UserResponseDtoFloat extends UserResponseDto<Float>{};
    private static class UserResponseDtoBool extends UserResponseDto<Boolean>{};
    private final Map<String, Type> responseDtoMap= Stream.of(new Object[][] {
            { "STR", UserResponseDtoStr.class },
            { "INT", UserResponseDtoNumber.class },
            { "FLOAT", UserResponseDtoFloat.class },
            { "BOOL", UserResponseDtoBool.class }
    }).collect(Collectors.toMap(data -> (String) data[0], data ->(Type) data[1]));

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper pojoMapper;

    @Override
    public List<UserResponseDto<?>> getAll() {
        List<UserResponseDto<?>> userDto= new ArrayList<>();
        userRepository.findAll().forEach(
                user -> userDto.add(pojoMapper.map(user, responseDtoMap.get(user.getUserSettingType())))
        );
        return userDto;
    }
}
