package com.inspire12.likelionbackend.module.order.infrastructure.listener.event;


import com.inspire12.likelionbackend.module.order.domain.constant.OrderStatus;

// TODO To Owner module @우재
public record OrderToStoreEvent(OrderStatus orderStatus) {
}
