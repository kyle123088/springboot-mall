package com.kyle.springbootmall.service.impl;

import com.kyle.springbootmall.dao.OrderDao;
import com.kyle.springbootmall.dao.ProductDao;
import com.kyle.springbootmall.dto.BuyItem;
import com.kyle.springbootmall.dto.CreateOrderRequest;
import com.kyle.springbootmall.model.Order;
import com.kyle.springbootmall.model.OrderItem;
import com.kyle.springbootmall.model.Product;
import com.kyle.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;

    @Override
    public Order getOrderById(Integer orderId) {

        Order order = orderDao.getOrderById(orderId);
        List<OrderItem> orderItemList = orderDao.getOrderByOrderId(orderId);

        order.setOrderItemList(orderItemList);
        return order;
    }

    // 這邊加 @Transactional 是確保兩個資料庫的操作
    // 例如：order table 新增成功， order_item table 新增失敗的情況
    // 同時新增成功 or 同時新增失敗
    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {

        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();


        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {
            // 從前端使用者提供的 productId 值，從資料庫中查詢出 product 出來
            Product product = productDao.getProductById(buyItem.getProductId());

            // 計算總價錢
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount += amount;

            // 轉換 BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }

        // 創建訂單
        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId, orderItemList);

        return orderId;
    }
}
