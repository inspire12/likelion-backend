package com.inspire12.likelionbackend.module.order.infrastructure.repository;

import com.inspire12.likelionbackend.module.order.domain.Order;
import org.springframework.stereotype.Component;

import java.util.UUID;


// TODO JPA 연동 이후 변경 예정
@Component
public interface OrderMemoryRepository {

    Order findByOrderNumber(UUID uuid);
    Order save(Order order);
}
