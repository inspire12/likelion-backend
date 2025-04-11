package com.inspire12.likelionbackend.module.order.application.service;

import com.inspire12.likelionbackend.module.order.application.dto.OrderRequest;
import com.inspire12.likelionbackend.module.order.application.dto.OrderResponse;
import com.inspire12.likelionbackend.module.order.domain.Order;
import com.inspire12.likelionbackend.module.order.domain.OrderRepository;
import com.inspire12.likelionbackend.module.order.support.factory.OrderFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    public OrderResponse getOrderById(Long orderId) {
        return OrderFactory.createOrderResponse(orderRepository.getOrderById(orderId));
    }


    public OrderResponse getOrderByOrderNumber(String orderNumber) {
        return OrderFactory.createOrderResponse(orderRepository.getOrderByOrderNumber(orderNumber));
    }

    public OrderResponse save(OrderRequest orderRequest) {
        UUID orderNumber = UUID.randomUUID();
        Order order = orderRepository.save(OrderFactory.createOrder(orderRequest, orderNumber));
        return OrderFactory.createOrderResponse(order);
    }
}
