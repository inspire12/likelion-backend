package com.inspire12.likelionbackend.module.jpa.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderListResponse {
    List<OrderResponse> orderResponses;
}
