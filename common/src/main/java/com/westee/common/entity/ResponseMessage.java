package com.westee.common.entity;

public enum ResponseMessage {
    OK,
    FAIL;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
