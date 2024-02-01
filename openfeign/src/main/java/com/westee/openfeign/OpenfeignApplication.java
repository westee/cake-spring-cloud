package com.westee.openfeign;

import com.westee.openfeign.client.RoleServiceProviderClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(clients = {RoleServiceProviderClient.class})
public class OpenfeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenfeignApplication.class, args);
    }
}
