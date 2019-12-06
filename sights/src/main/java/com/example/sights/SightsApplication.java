package com.example.sights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SightsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SightsApplication.class, args);
    }

}
