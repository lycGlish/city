package com.lyc.city.city;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lyc
 * @date 2020/7/9 11:30
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lyc.city.city.dao")
public class CityProvider7011 {

    public static void main(String[] args) {
        SpringApplication.run(CityProvider7011.class, args);
    }
}
