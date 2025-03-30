package com.inspire12.likelionbackend.module.jpa.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderRequest {
    private Long customerId;
    private Integer totalAmount;
}