package com.inspire12.likelionbackend.module.jpa.enums;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum OrderStatus {
    @JsonEnumDefaultValue PENDING_PAYMENT, // 결제 전
    FAIL_PAYMENT, // 결제 실패
    ORDERED,      // 주문 완료
    ACCEPTED,     // 접수 완료
    PREPARING,    // 준비 중
    DELIVERING,   // 배달 중
    DELIVERED,    // 배달 완료
    CANCELLED     // 주문 취소
}
