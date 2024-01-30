package com.westee.goodsservice.controller;

import com.westee.common.entity.Response;
import com.westee.goodsservice.generate.Config;
import com.westee.goodsservice.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("api/v1/")
public class ConfigController {
    private final ConfigService configService;
    private final RestTemplate restTemplate;

    @Autowired
    public ConfigController(ConfigService configService, RestTemplate restTemplate) {
        this.configService = configService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("config")
    public Response<Config> postConfig(@RequestBody Config config,
                                       @RequestHeader("Token") String token){
//        @TODO
//        使用restTemplate请求权限
//        restTemplate.exchange()
        return Response.ok(configService.updateConfig(config));
    }
}
