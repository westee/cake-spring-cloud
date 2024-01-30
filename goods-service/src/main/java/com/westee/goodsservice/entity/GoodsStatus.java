package com.westee.goodsservice.entity;

public enum GoodsStatus {
    OK(),
    DELETED(),
    ZERO(); // 0 售罄

    public String getName() {
        return  name().toLowerCase();
    }
}
