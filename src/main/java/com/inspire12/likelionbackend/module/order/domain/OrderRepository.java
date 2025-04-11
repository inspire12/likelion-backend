package com.inspire12.likelionbackend.module.order.domain;


import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository {

    Order getOrderById(Long orderId);


    Order getOrderByOrderNumber(String orderNumber);

    Order save(Order order);
}
