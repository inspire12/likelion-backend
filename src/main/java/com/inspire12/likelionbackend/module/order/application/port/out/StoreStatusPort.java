package com.inspire12.likelionbackend.module.order.application.port.out;

public interface StoreStatusPort {
    Boolean getStoreOpenStatus(Long storeId);
    Boolean getStoreOpenStatusByOrderNumber(String orderNumber);
}
