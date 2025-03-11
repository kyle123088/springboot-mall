package com.kyle.springbootmall.service;

import com.kyle.springbootmall.dto.CreateOrderRequest;
import com.kyle.springbootmall.dto.OrderQueryParams;
import com.kyle.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
