package com.inspire12.likelionbackend.module.jpa.controller;

import com.inspire12.likelionbackend.module.jpa.model.request.OrderRequest;
import com.inspire12.likelionbackend.module.jpa.model.response.OrderListResponse;
import com.inspire12.likelionbackend.module.jpa.model.response.OrderResponse;
import com.inspire12.likelionbackend.module.jpa.model.response.OrderSumResponse;
import com.inspire12.likelionbackend.module.jpa.model.response.OrderSummaryResponse;
import com.inspire12.likelionbackend.module.jpa.service.OrderService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/orders")
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // 주문 조회 API
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long orderId) {
        OrderResponse orderResponse = orderService.getOrder(orderId);
        return ResponseEntity.ok(orderResponse);
    }

    // 주문 조회 API
    @GetMapping
    public ResponseEntity<OrderListResponse> getOrder(
            @PageableDefault(page = 1, size = 10, sort = {"id"}, direction = Sort.Direction.ASC)
            Pageable pageRequest) {
        OrderListResponse orderByPager = orderService.getOrderByPager(pageRequest);

        return ResponseEntity.ok(orderByPager);
    }

    // 주문 생성
    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {
        OrderResponse orderResponse = orderService.saveOrder(request);
        return ResponseEntity.ok(orderResponse);
    }

    // 주문 삭제
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

    // 주문 금액 수정
    @PutMapping("/{orderId}/amount")
    public ResponseEntity<OrderResponse> updateTotalAmount(
            @PathVariable Long orderId,
            @RequestParam Integer amount) {
        OrderResponse orderResponse = orderService.updateTotalAmount(orderId, amount);
        return ResponseEntity.ok(orderResponse);
    }

    // 주문 조회 API
    @GetMapping("/summary")
    public ResponseEntity<OrderSummaryResponse> getOrderSummary(@RequestParam Long customerId) {
        OrderSummaryResponse orderSummaries = orderService.getOrderSummaries(customerId);
        return ResponseEntity.ok(orderSummaries);
    }

    @GetMapping("/sum")
    public ResponseEntity<OrderSumResponse> getOrderSum(@RequestParam Long customerId) {
        OrderSumResponse orderSummaries = orderService.getOrderSum(customerId);
        return ResponseEntity.ok(orderSummaries);
    }

}
