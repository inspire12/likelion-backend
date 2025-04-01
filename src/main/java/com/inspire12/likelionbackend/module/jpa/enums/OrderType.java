package com.inspire12.likelionbackend.module.jpa.enums;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum OrderType {
    @JsonEnumDefaultValue DELIVERY,
    PICKUP
}