package com.feeltech.appbee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication

public class AppbeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppbeeApplication.class, args);
    }

}
