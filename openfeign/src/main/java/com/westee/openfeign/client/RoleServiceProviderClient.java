package com.westee.openfeign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("auth-service")
public interface RoleServiceProviderClient {

    @RequestMapping(value = "/api/v1/role", method = RequestMethod.GET)
    List<String> getData();
}
