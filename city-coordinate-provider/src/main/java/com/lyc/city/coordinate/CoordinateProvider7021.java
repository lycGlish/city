package com.lyc.city.coordinate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lyc
 * @date 2020/7/8 17:18
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lyc.city.coordinate.dao")
public class CoordinateProvider7021 {

    public static void main(String[] args) {
        SpringApplication.run(CoordinateProvider7021.class, args);
    }
}
