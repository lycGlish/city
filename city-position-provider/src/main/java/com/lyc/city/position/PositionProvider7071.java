package com.lyc.city.position;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lyc
 * @date 2020/7/9 10:06
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lyc.city.position.dao")
public class PositionProvider7071 {

    public static void main(String[] args) {
        SpringApplication.run(PositionProvider7071.class, args);
    }
}
