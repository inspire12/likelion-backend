package com.inspire12.likelionbackend.module.jpa.model.response;

import com.inspire12.likelionbackend.module.jpa.model.dto.OrderSummary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderSummaryResponse {
    List<OrderSummary> orderSummaries;
}
