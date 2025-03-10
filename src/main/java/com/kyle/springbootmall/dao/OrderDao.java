package com.kyle.springbootmall.dao;

import com.kyle.springbootmall.dto.CreateOrderRequest;
import com.kyle.springbootmall.model.Order;
import com.kyle.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderByOrderId(Integer orderId);

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
