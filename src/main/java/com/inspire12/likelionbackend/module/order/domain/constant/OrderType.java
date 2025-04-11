package com.inspire12.likelionbackend.module.order.domain.constant;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum OrderType {
    @JsonEnumDefaultValue DELIVERY,
    PICKUP
}
