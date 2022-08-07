package com.ecsdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class Applicativo {
    public static void main(String[] args) {
        SpringApplication.run(Applicativo.class, args);
    }
}
