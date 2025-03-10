package com.kyle.springbootmall.controller;

import com.kyle.springbootmall.dto.CreateOrderRequest;
import com.kyle.springbootmall.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    // 假設需要登入才可以下訂單(帳號存在下訂單才有意義)
    // 從眾多 users 當中的某個 user 的 orders
    @PostMapping("users/{userId}/orders")
    public ResponseEntity<?> createOrder(@PathVariable Integer userId,
                                         @RequestBody @Valid CreateOrderRequest createOrderRequest) {
        // 預期 orderService 會提供一個 createOrder 方法，會返回一個 orderId
        Integer orderId = orderService.createOrder(userId, createOrderRequest);

        // 返回給前端 orederId
        return ResponseEntity.status(HttpStatus.CREATED).body(orderId);
    }
}
