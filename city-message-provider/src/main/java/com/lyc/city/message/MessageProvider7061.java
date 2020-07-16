package com.lyc.city.message;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lyc
 * @date 2020/7/9 9:32
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lyc.city.message.dao")
public class MessageProvider7061 {

    public static void main(String[] args) {
        SpringApplication.run(MessageProvider7061.class, args);
    }
}
