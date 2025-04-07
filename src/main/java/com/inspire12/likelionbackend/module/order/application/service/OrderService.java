package com.inspire12.likelionbackend.module.order.application.service;

import com.inspire12.likelionbackend.module.order.application.dto.OrderRequest;
import com.inspire12.likelionbackend.module.order.application.dto.OrderResponse;
import com.inspire12.likelionbackend.module.order.application.port.out.PaymentPort;
import com.inspire12.likelionbackend.module.order.domain.Order;
import com.inspire12.likelionbackend.module.order.domain.OrderRepository;
import com.inspire12.likelionbackend.module.order.enums.OrderStatus;
import com.inspire12.likelionbackend.module.order.support.mapper.OrderMapper;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final PaymentPort paymentPort;

    public OrderService(OrderRepository orderRepository, PaymentPort paymentPort) {
        this.orderRepository = orderRepository;
        this.paymentPort = paymentPort;
    }


    public Order confirmOrderPayment(OrderRequest orderRequest) {
        // 주문 도메인 객체를 만들고
        Order order = orderRepository.getOrderByCustomerId(orderRequest.customerId());
        // 결제를 요청해 처리하고
        boolean isPaymentSuccess = paymentPort.processPayment(order);

        order.approvePayment(isPaymentSuccess);

        return order;
    }

    public OrderResponse getOrderByOrderId(Long orderId) {
        Order orderByOrderId = orderRepository.getOrderByOrderId(orderId);
        return OrderMapper.toResponse(orderByOrderId);
    }
}
