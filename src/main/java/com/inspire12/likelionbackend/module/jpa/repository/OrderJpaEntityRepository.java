package com.inspire12.likelionbackend.module.jpa.repository;

import com.inspire12.likelionbackend.module.jpa.model.entity.OrderEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class OrderJpaEntityRepository  {

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<OrderEntity> findByOrderId(Long orderId) {
        String jpql = "select o from OrderEntity o where o.id=:orderId";
        return Optional.ofNullable(entityManager.createQuery(jpql, OrderEntity.class)
                .setParameter("orderId", orderId)
                .getSingleResult());
    }
}
