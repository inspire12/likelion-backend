package com.inspire12.likelionbackend.module.order.application.dto;


import com.inspire12.likelionbackend.module.order.domain.constant.OrderType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private long customerId;
    private long storeId;
    private OrderType orderType;
}
