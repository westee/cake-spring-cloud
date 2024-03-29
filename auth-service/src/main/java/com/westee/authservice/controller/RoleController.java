package com.westee.authservice.controller;

import com.westee.authservice.entity.Response;
import com.westee.authservice.generate.Role;
import com.westee.authservice.service.RoleService;
import com.westee.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class RoleController {
    private final RoleService roleService;
    private final UserService userService;

    @Autowired
    public RoleController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("role")
    public Response<Role> getUserRole(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        Long roleId = userService.getUserByToken(token.substring(7)).getRoleId();
        Role userRoleById = roleService.getUserRoleById(roleId);
        if (userRoleById == null) {
            Response.fail();
        }
        return Response.ok(userRoleById);
    }

}
