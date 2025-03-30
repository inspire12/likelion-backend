package com.inspire12.likelionbackend.model.entity;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum OrderStatus {
    @JsonEnumDefaultValue PENDING_PAYMENT,
    CANCEL_PAYMENT,
    FAIL_PAYMENT,
}
