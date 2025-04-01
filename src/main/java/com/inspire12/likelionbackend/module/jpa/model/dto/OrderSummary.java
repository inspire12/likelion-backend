package com.inspire12.likelionbackend.module.jpa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderSummary {
    private Long id;
    private String orderNumber;
    private Integer totalAmount;
}