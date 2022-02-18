package com.prdcv.learnspring.service.facade;

import com.prdcv.learnspring.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    public List<UserResponseDto<?>> getAll();

}
