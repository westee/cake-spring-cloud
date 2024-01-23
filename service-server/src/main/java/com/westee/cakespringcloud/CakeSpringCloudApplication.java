package com.westee.cakespringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //当前使用eureka的server
public class CakeSpringCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CakeSpringCloudApplication.class, args);
    }

}
