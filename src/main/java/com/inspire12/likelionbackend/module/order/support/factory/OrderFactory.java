package com.inspire12.likelionbackend.module.order.support.factory;


import com.inspire12.likelionbackend.module.order.application.dto.OrderRequest;
import com.inspire12.likelionbackend.module.order.application.dto.OrderResponse;
import com.inspire12.likelionbackend.module.order.domain.Order;
import com.inspire12.likelionbackend.module.order.domain.constant.OrderStatus;
import com.inspire12.likelionbackend.module.order.infrastructure.repository.entity.OrderEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class OrderFactory {
    public static OrderResponse createOrderResponse(Order order) {
        return OrderResponse.builder()
                .orderStatus(order.getOrderStatus())
                .orderNumber(order.getOrderNumber())
                .build();
    }

    public static Order createOrder(OrderEntity orderEntity) {
        return Order.builder()
                .id(orderEntity.getId())
                .storeId(orderEntity.getStoreId())
                .customerId(orderEntity.getCustomerId())
                .createdAt(orderEntity.getCreatedAt())
                .updatedAt(orderEntity.getUpdatedAt())
                .orderType(orderEntity.getOrderType())
                .orderStatus(orderEntity.getOrderStatus())
                .orderNumber(orderEntity.getOrderNumber())
                .build();
    }

    public static Order createOrder(OrderRequest orderRequest, UUID orderNumber) {
        return Order.builder()
                .storeId(orderRequest.getStoreId())
                .customerId(orderRequest.getCustomerId())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .orderType(orderRequest.getOrderType())
                .orderStatus(OrderStatus.PENDING_PAYMENT)
                .orderNumber(orderNumber)
                .build();
    }
}
