package com.inspire12.likelionbackend.repository;

import com.inspire12.likelionbackend.model.entity.OrderEntity;

import java.util.Optional;

public interface OrderRepositoryCustom {
    Optional<OrderEntity> findQueryDslById(Long orderId);
}
