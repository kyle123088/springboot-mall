package com.kyle.springbootmall.controller;

import com.kyle.springbootmall.dto.CreateOrderRequest;
import com.kyle.springbootmall.dto.OrderQueryParams;
import com.kyle.springbootmall.model.Order;
import com.kyle.springbootmall.service.OrderService;
import com.kyle.springbootmall.util.Page;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    // 查詢訂單列表功能
    @GetMapping("/users/{userId}/orders")
    public ResponseEntity<Page<Order>> getOrders(
            @PathVariable Integer userId,
            @RequestParam(defaultValue = "10") @Max(1000) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset
    ) {
        OrderQueryParams orderQueryParams = new OrderQueryParams();
        orderQueryParams.setUserId(userId);
        orderQueryParams.setLimit(limit);
        orderQueryParams.setOffset(offset);

        // 取得 order list
        List<Order> orderList = orderService.getOrders(orderQueryParams);

        // 取得 order 總數
        Integer count = orderService.countOrder(orderQueryParams);

        // 分頁
        Page<Order> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(count);
        page.setResults(orderList);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    // 假設需要登入才可以下訂單(帳號存在下訂單才有意義)
    // 從眾多 users 當中的某個 user 的 orders
    @PostMapping("users/{userId}/orders")
    public ResponseEntity<?> createOrder(@PathVariable Integer userId,
                                         @RequestBody @Valid CreateOrderRequest createOrderRequest) {
        // 預期 orderService 會提供一個 createOrder 方法，會返回一個 orderId
        Integer orderId = orderService.createOrder(userId, createOrderRequest);

        // 取得 orderId 後，將訂單回傳給前端
        Order order = orderService.getOrderById(orderId);

        // 返回給前端 orederId
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
}
