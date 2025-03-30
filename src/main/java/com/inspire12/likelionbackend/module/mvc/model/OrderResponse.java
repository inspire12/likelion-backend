package com.inspire12.likelionbackend.module.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private Long customerId;
    private Long productId;
    private LocalDateTime createdAt;
}
