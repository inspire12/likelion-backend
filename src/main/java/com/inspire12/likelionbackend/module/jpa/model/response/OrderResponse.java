package com.inspire12.likelionbackend.module.jpa.model.response;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
public class OrderResponse {
    private Long id;
    private Long customerId;
    private String orderNumber;
    private Integer totalAmount;
    private LocalDateTime createdAt;

}

