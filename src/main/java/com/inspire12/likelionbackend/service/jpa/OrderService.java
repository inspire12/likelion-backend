package com.inspire12.likelionbackend.service.jpa;

import com.inspire12.likelionbackend.config.core.TransactionExecutor;
import com.inspire12.likelionbackend.context.UserContextHolder;
import com.inspire12.likelionbackend.model.entity.OrderEntity;
import com.inspire12.likelionbackend.model.entity.OrderStatus;
import com.inspire12.likelionbackend.model.response.OrderResponse;
import com.inspire12.likelionbackend.repository.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    private final @Qualifier("inspire12TransactionMananger") PlatformTransactionManager transactionManager;
    private final TransactionExecutor transactionExecutor;

    private final OrderJpaRepository orderJpaRepository;
//    private final OrderJpaEntityRepository orderJpaEntityRepository;

    public OrderResponse getOrderById(Long orderId) {

        OrderEntity orderEntity = orderJpaRepository.findById(orderId)
                .orElseThrow(RuntimeException::new);
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


    @Transactional
    public OrderResponse saveOrderByUserId(Long userId) {

        String username = UserContextHolder.getAuthenticatedUsername();

        log.info("request save order by userId: {} username: {}", userId, username);
        OrderEntity orderEntity = OrderEntity.builder()
                .customerId(userId)
                .orderStatus(OrderStatus.PENDING_PAYMENT)
                .updatedAt(LocalDateTime.now())
                .orderNumber(UUID.randomUUID()).build();
        OrderEntity orderSaved = orderJpaRepository.save(orderEntity);
        return OrderResponse.builder()
                .customerId(orderSaved.getCustomerId())
                .orderNumber(orderSaved.getOrderNumber())
                .updatedAt(LocalDateTime.now())
                .orderStatus(orderSaved.getOrderStatus()).build();
    }

    public OrderResponse saveOrderTransaction(Long userId) {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            // 주문 처리 로직
            OrderEntity orderEntity = OrderEntity.builder()
                    .customerId(userId)
                    .orderStatus(OrderStatus.PENDING_PAYMENT)
                    .updatedAt(LocalDateTime.now())
                    .orderNumber(UUID.randomUUID()).build();
            OrderEntity orderSaved = orderJpaRepository.save(orderEntity);
            transactionManager.commit(status);

            return OrderResponse.builder()
                    .customerId(orderSaved.getCustomerId())
                    .orderNumber(orderSaved.getOrderNumber())
                    .updatedAt(LocalDateTime.now())
                    .orderStatus(orderSaved.getOrderStatus()).build();
        } catch(Exception e) {
            transactionManager.rollback(status);
        }
        throw new RuntimeException("Order transaction failed");
    }

    public OrderResponse saveOrderExecutor(Long userId) {
        return transactionExecutor.executeInTransaction(() -> {
            // 주문 처리 로직
            OrderEntity orderEntity = OrderEntity.builder()
                    .customerId(userId)
                    .orderStatus(OrderStatus.PENDING_PAYMENT)
                    .updatedAt(LocalDateTime.now())
                    .orderNumber(UUID.randomUUID()).build();
            OrderEntity orderSaved = orderJpaRepository.save(orderEntity);
            return OrderResponse.builder()
                    .customerId(orderSaved.getCustomerId())
                    .orderNumber(orderSaved.getOrderNumber())
                    .updatedAt(LocalDateTime.now())
                    .orderStatus(orderSaved.getOrderStatus()).build();
        });
    }
}
