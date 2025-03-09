package com.kyle.springbootmall.dao;

import com.kyle.springbootmall.dto.UserRegisterRequest;
import com.kyle.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}
