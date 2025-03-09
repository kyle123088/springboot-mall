package com.kyle.springbootmall.service;

import com.kyle.springbootmall.dto.UserLoginRequest;
import com.kyle.springbootmall.dto.UserRegisterRequest;
import com.kyle.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);
}
