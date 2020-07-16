package com.lyc.city;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lyc
 * @date 2020/7/15 15:44
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lyc.city.city.dao")
public class ResultProvider7091 {

    public static void main(String[] args) {
        SpringApplication.run(ResultProvider7091.class, args);
    }
}
