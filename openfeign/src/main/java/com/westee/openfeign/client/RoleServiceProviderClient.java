package com.westee.openfeign.client;

import com.westee.common.entity.Response;
import com.westee.common.entity.Role;
import com.westee.common.entity.User;
import com.westee.openfeign.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 可以从eureka server中找到spring.application.name = auth-service的服务
 * 以代替地址访问，如auth-service/api/v1/role，更加直观。
 */
@FeignClient(value = "auth-service", configuration = FeignConfig.class)
public interface RoleServiceProviderClient {

    @RequestMapping(value = "/api/v1/role", method = RequestMethod.GET)
    Response<Role> getRole(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String Token);

    @RequestMapping(value = "/api/v1/user", method = RequestMethod.GET)
    Response<User> getUser(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String Token);

    @RequestMapping(value = "/api/v1/users/ids", method = RequestMethod.GET)
    Response<List<Long>> getUsersIds(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String Token);

}
