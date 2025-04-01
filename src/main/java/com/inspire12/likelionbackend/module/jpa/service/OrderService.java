package com.inspire12.likelionbackend.module.jpa.service;

import com.inspire12.likelionbackend.module.jpa.model.entity.OrderEntity;
import com.inspire12.likelionbackend.module.jpa.model.mapper.OrderMapper;
import com.inspire12.likelionbackend.module.jpa.model.request.OrderRequest;
import com.inspire12.likelionbackend.module.jpa.model.response.OrderResponse;
import com.inspire12.likelionbackend.module.jpa.model.response.OrderSumResponse;
import com.inspire12.likelionbackend.module.jpa.model.response.OrderSummaryResponse;
import com.inspire12.likelionbackend.module.jpa.repository.OrderJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderJpaRepository orderJpaRepository;


    @Transactional(readOnly = true)
    public OrderResponse getOrder(Long orderId) {
        OrderEntity order = orderJpaRepository.selectById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("주문 없음"));
        return OrderMapper.fromEntity(order);
    }

    @Transactional
    public OrderResponse saveOrder(OrderRequest request) {
        OrderEntity order = OrderMapper.toEntity(request);
        OrderEntity savedOrder = orderJpaRepository.save(order);
        return OrderMapper.fromEntity(savedOrder);
    }

    @Transactional
    public void deleteOrder(Long orderId) {
        OrderEntity order = orderJpaRepository.selectById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("주문 없음"));
        orderJpaRepository.deleteJPQLById(order.getId());
    }

//    @Transactional
    public OrderResponse updateTotalAmount(Long orderId, Integer newAmount) {
        OrderEntity order = orderJpaRepository.selectById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("주문 없음"));
        if (orderJpaRepository.updateTotalAmountById(orderId, newAmount) == 1) {
            order.changeTotalAmount(newAmount);
        };
        return OrderMapper.fromEntity(order);
    }


    // 고객 ID로 주문 요약 정보 조회
    @Transactional(readOnly = true)
    public OrderSummaryResponse getOrderSummaries(Long customerId) {
        return new OrderSummaryResponse(orderJpaRepository.findOrderSummariesByCustomerId(customerId));
    }

    public OrderSumResponse getOrderSum(Long customerId) {
        // TODO
        throw new UnsupportedOperationException();
    }
}
