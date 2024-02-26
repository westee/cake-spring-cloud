package com.westee.authservice.controller;

import com.westee.authservice.entity.Response;
import com.westee.authservice.generate.User;
import com.westee.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("users/ids")
    public Response<List<Long>> getUsersByToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        User userByToken = userService.getUserByToken(token.substring(7));
        if (userByToken == null) {
            return Response.fail();
        }
        List<Long> userIds = userService.getUserIds(token);
        return Response.ok(userIds);
    }

}
