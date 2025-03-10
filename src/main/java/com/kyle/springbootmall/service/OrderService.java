package com.kyle.springbootmall.service;

import com.kyle.springbootmall.dto.CreateOrderRequest;
import com.kyle.springbootmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
