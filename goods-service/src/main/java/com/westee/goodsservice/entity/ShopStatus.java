package com.westee.goodsservice.entity;

public enum ShopStatus {
    OK(),
    DELETED(),
    ZERO(); // 0 售罄

    public String getName() {
        return  name().toLowerCase();
    }
}
