package com.lyc.city.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lyc
 * @date 2020/7/15 15:35
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lyc.city.user.dao")
public class UserProvider7101 {

    public static void main(String[] args) {
        SpringApplication.run(UserProvider7101.class, args);
    }
}
