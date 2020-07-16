package com.lyc.city.district;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lyc
 * @date 2020/7/15 16:07
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lyc.city.city.dao")
public class DistrictProvider7031 {

    public static void main(String[] args) {
        SpringApplication.run(DistrictProvider7031.class, args);
    }
}
