package com.kyle.springbootmall.controller;

import com.kyle.springbootmall.dto.UserLoginRequest;
import com.kyle.springbootmall.dto.UserRegisterRequest;
import com.kyle.springbootmall.model.User;
import com.kyle.springbootmall.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {
        // 預設 register 方法會為使用者，在資料庫中建立一筆新的 user 數據，並返回資料庫生成的 userId
        Integer userId = userService.register(userRegisterRequest);

        // 建立帳號成功後，使用 userId 去查詢該帳號數據回來
        User user = userService.getUserById(userId);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/users/login")
    public ResponseEntity<User> login(@RequestBody @Valid UserLoginRequest userLoginRequest) {
        // login 方法預設前端提供的信箱密碼，是否能正確登入
        User user = userService.login(userLoginRequest);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
