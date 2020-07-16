package com.lyc.city.province;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lyc
 * @date 2020/7/9 11:14
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lyc.city.province.dao")
public class ProvinceProvider7081 {

    public static void main(String[] args) {
        SpringApplication.run(ProvinceProvider7081.class, args);
    }
}
