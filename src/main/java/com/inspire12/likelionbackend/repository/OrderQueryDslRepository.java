package com.inspire12.likelionbackend.repository;

import com.inspire12.likelionbackend.model.entity.OrderEntity;
import com.inspire12.likelionbackend.model.entity.QOrderEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderQueryDslRepository implements OrderRepositoryCustom {

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
}
