package com.lyc.city.image;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lyc
 * @date 2020/7/8 16:35
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lyc.city.image.dao")
public class ImageProvider7041 {

    public static void main(String[] args) {
        SpringApplication.run(ImageProvider7041.class, args);
    }
}
