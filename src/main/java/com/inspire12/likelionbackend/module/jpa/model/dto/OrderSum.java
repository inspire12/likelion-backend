package com.inspire12.likelionbackend.module.jpa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderSum {
    private Long customerId;
    private Long count;
}
