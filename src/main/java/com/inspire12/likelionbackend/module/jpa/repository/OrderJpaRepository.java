package com.inspire12.likelionbackend.module.jpa.repository;

import com.inspire12.likelionbackend.module.jpa.model.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {

    @Query("select o from OrderEntity o where o.id=:orderId")
    Optional<OrderEntity> findByOrderId(Long orderId);

    List<OrderEntity> findByTotalAmountBetween(Integer totalAmountAfter, Integer totalAmountBefore);

}
