package com.kyle.springbootmall.service.impl;

import com.kyle.springbootmall.dao.UserDao;
import com.kyle.springbootmall.dto.UserRegisterRequest;
import com.kyle.springbootmall.model.User;
import com.kyle.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }
}
