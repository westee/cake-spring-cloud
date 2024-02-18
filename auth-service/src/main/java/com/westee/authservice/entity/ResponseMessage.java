package com.westee.authservice.entity;

public enum ResponseMessage {
    OK,
    FAIL;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
