package com.lyc.city.camera;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lyc
 * @date 2020/7/15 15:27
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lyc.city.camera.dao")
public class CameraProvider7001 {

    public static void main(String[] args) {
        SpringApplication.run(CameraProvider7001.class, args);
    }
}
