package com.inspire12.likelionbackend.module.jpa.repository;

import com.inspire12.likelionbackend.module.jpa.model.dto.OrderSum;
import com.inspire12.likelionbackend.module.jpa.model.entity.OrderEntity;
import com.inspire12.likelionbackend.module.jpa.model.entity.QOrderEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryCustomImpl implements OrderRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<OrderEntity> findQueryDslById(Long orderId) {
        QOrderEntity orderQuery = QOrderEntity.orderEntity;
        // "select o from OrderEntity o where o.id=:orderId"
        return Optional.ofNullable(queryFactory.selectFrom(orderQuery)
                .where(orderQuery.id.eq(orderId))
//                        .orderBy()
//                        .groupBy()
                .fetchOne());
    }


    @Override
    public OrderSum sumQueryDslAmountByUserId(Long customerId) {
        QOrderEntity orderQuery = QOrderEntity.orderEntity;
        /* TODO
        @Query("select new com.inspire12.likelionbackend.module.jpa.model.dto.OrderSum(o.customerId, sum(o.totalAmount))
         from OrderEntity o where o.customerId=:customerId"
         코드를 QueryDsl 로 옮겨보기
         */
        
//        return orderSum;
        throw new UnsupportedOperationException();
    }
}
