package com.lyc.city.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lyc
 * @date 2020/7/22 11:20
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Gateway9001 {

    public static void main(String[] args) {
        SpringApplication.run(Gateway9001.class, args);
    }
}
