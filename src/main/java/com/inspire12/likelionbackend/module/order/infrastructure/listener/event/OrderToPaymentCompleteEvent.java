package com.inspire12.likelionbackend.module.order.infrastructure.listener.event;



import com.inspire12.likelionbackend.module.order.domain.constant.OrderStatus;

import java.util.UUID;

// TODO payment가 끝났을 때 Order에게 요청 @희동
public record OrderToPaymentCompleteEvent(Long orderId,
                                          OrderStatus orderStatus,
                                          UUID orderNumber) {
}

