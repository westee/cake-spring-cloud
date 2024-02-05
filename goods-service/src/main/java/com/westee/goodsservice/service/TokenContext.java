package com.westee.goodsservice.service;

public class TokenContext {

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void setCurrentToken(String token) {
        threadLocal.set(token);
    }

    public static String getCurrentToken() {
        return threadLocal.get();
    }

    public static void clearCurrentToken() {
        threadLocal.remove();
    }

}
