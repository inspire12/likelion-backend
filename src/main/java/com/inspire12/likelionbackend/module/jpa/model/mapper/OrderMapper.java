package com.inspire12.likelionbackend.module.jpa.model.mapper;

import com.inspire12.likelionbackend.module.jpa.model.entity.OrderEntity;
import com.inspire12.likelionbackend.module.jpa.model.request.OrderRequest;
import com.inspire12.likelionbackend.module.jpa.model.response.OrderResponse;

import java.time.LocalDateTime;
import java.util.UUID;


public class OrderMapper {

    private OrderMapper() {
    }

    public static OrderEntity toEntity(OrderRequest request) {
        return OrderEntity.builder()
                .customerId(request.getCustomerId()) // 추가된 부분
                .orderNumber(UUID.randomUUID().toString())
                .totalAmount(request.getTotalAmount())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static OrderResponse fromEntity(OrderEntity order) {
        return new OrderResponse(
                order.getId(),
                order.getCustomerId(),
                order.getOrderNumber(),
                order.getTotalAmount(),
                order.getCreatedAt()
        );
    }
}
