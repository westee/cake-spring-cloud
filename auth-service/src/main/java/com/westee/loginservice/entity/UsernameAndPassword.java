package com.westee.loginservice.entity;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class UsernameAndPassword {
    @NotBlank(message = "用户名不能为空")
    @Length(min = 2, max = 32, message = "用户名长度 [2, 32]")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 32, message = "密码长度 [6, 32]")
    private String password;

    public UsernameAndPassword(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
