package com.inspire12.likelionbackend.sample;

import com.inspire12.likelionbackend.module.order.application.dto.OrderResponse;
import com.inspire12.likelionbackend.module.order.domain.constant.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/sample")
@RequiredArgsConstructor
@RestController
public class SampleController {
    @GetMapping("/orders")
    public ResponseEntity<OrderResponse> getSampleOrder() {

        OrderResponse build = OrderResponse.builder().orderNumber(UUID.randomUUID()).orderStatus(OrderStatus.PENDING_PAYMENT).build();
        return ResponseEntity.ok(build);
    }

}
