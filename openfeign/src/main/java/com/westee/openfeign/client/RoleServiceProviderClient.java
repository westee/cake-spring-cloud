package com.westee.openfeign.client;

import com.westee.common.entity.Role;
import com.westee.openfeign.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "auth-service", configuration = FeignConfig.class)
public interface RoleServiceProviderClient {

    @RequestMapping(value = "/api/v1/role", method = RequestMethod.GET)
    Role getData(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String Token);

}
