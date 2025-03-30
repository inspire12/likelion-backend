package com.inspire12.likelionbackend.module.jpa.repository;

import com.inspire12.likelionbackend.module.jpa.model.dto.OrderSum;
import com.inspire12.likelionbackend.module.jpa.model.entity.OrderEntity;

import java.util.Optional;

public interface OrderRepositoryCustom {
    Optional<OrderEntity> findQueryDslById(Long orderId);
    OrderSum sumQueryDslAmountByUserId(Long customerId);
}
