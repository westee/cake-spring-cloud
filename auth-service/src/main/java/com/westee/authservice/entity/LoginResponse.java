package com.westee.authservice.entity;

import com.westee.authservice.generate.User;

public class LoginResponse {
    private boolean login;
    private User user;

    public static LoginResponse alreadyLogin(User user) {
        return new LoginResponse(true, user);
    }
    public static LoginResponse notLogin() {
        return new LoginResponse(false, null);
    }

    public LoginResponse() {

    }

    public LoginResponse(boolean login, User user) {
        this.login = login;
        this.user = user;
    }

    public boolean isLogin() {
        return login;
    }

    public User getUser() {
        return user;
    }
}
