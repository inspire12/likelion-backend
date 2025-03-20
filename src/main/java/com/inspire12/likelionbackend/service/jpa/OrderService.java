package com.inspire12.likelionbackend.service.jpa;

import com.inspire12.likelionbackend.model.entity.OrderEntity;
import com.inspire12.likelionbackend.model.entity.OrderStatus;
import com.inspire12.likelionbackend.model.response.OrderResponse;
import com.inspire12.likelionbackend.repository.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderJpaRepository orderJpaRepository;
//    private final OrderJpaEntityRepository orderJpaEntityRepository;

    public OrderResponse getOrderById(Long orderId) {
        OrderEntity orderEntity = orderJpaRepository.findQueryDslById(orderId)
                .orElseThrow(RuntimeException::new);

//        OrderEntity orderEntity = orderJpaRepository.findById(orderId)
//                .orElseThrow(RuntimeException::new);
//        OrderEntity orderEntity = orderJpaRepository.findByOrderId(orderId)
//                .orElseThrow(RuntimeException::new);

//        OrderEntity orderEntity = orderJpaEntityRepository.findByOrderId(orderId)
//                .orElseThrow(RuntimeException::new);

        OrderResponse orderResponse = OrderResponse.builder()
                .customerId(orderEntity.getCustomerId())
                .updatedAt(orderEntity.getUpdatedAt())
                .orderStatus(orderEntity.getOrderStatus())
                .orderNumber(orderEntity.getOrderNumber())
                .build();

        return orderResponse;
    }


    public OrderResponse saveOrderByUserId(Long userId) {
        OrderEntity order = orderJpaRepository.save(OrderEntity.builder()
                .customerId(userId)
                .orderStatus(OrderStatus.PENDING_PAYMENT)
                .updatedAt(LocalDateTime.now())
                .orderNumber(UUID.randomUUID()).build());
        return OrderResponse.builder()
                .customerId(order.getCustomerId())
                .orderNumber(order.getOrderNumber())
                .updatedAt(LocalDateTime.now())
                .orderStatus(order.getOrderStatus()).build();
    }
}
