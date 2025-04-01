package com.inspire12.likelionbackend.module.jpa.repository;

import com.inspire12.likelionbackend.module.jpa.model.dto.OrderSum;
import com.inspire12.likelionbackend.module.jpa.model.dto.OrderSummary;
import com.inspire12.likelionbackend.module.jpa.model.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {

    @Query("select o from OrderEntity o where o.id=:orderId")
    Optional<OrderEntity> findByOrderId(Long orderId);

    @Query("SELECT new com.inspire12.likelionbackend.module.jpa.model.dto.OrderSummary(o.id, o.orderNumber, o.totalAmount) " +
            "FROM OrderEntity o WHERE o.customerId = :customerId")
    List<OrderSummary> findOrderSummariesByCustomerId(@Param("customerId") Long customerId);

    // TODO
    @Query("select sum(o.totalAmount) from OrderEntity o where o.customerId=:customerId")
    OrderSum sumAmountByUserId(Long customerId);

    // findById
    @Query("select o from OrderEntity o where o.id= :id")
    Optional<OrderEntity> selectById(Long id);

    // update 대체
    @Modifying
    @Query("update OrderEntity o set o.totalAmount=:newAmount where o.id=:id")
    int updateTotalAmountById(Long id, Integer newAmount);

    @Query("delete from OrderEntity o where o.id=:id")
    void deleteJPQLById(Long id);
}
