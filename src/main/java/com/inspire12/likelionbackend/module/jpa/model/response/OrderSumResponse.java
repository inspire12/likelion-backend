package com.inspire12.likelionbackend.module.jpa.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderSumResponse {
    private Long customerId;
    private Long sum;
}
