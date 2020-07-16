package com.lyc.city.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lyc
 * @date 2020/7/15 14:42
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lyc.city.manager.dao")
public class ManagerProvider7051 {

    public static void main(String[] args) {
        SpringApplication.run(ManagerProvider7051.class, args);
    }
}
