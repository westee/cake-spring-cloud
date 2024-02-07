package com.westee.loginservice.controller;

import com.westee.loginservice.entity.Response;
import com.westee.loginservice.generate.User;
import com.westee.loginservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user")
    public Response<User> getUserByToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        User userByToken = userService.getUserByToken(token.substring(7));
        if (userByToken == null) {
            return Response.fail();
        }
        return Response.ok(userByToken);
    }

}
