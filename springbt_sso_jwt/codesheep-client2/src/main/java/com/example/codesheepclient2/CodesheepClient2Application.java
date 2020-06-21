package com.example.codesheepclient2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CodesheepClient2Application {

    public static void main(String[] args) {
        SpringApplication.run(CodesheepClient2Application.class, args);
    }

}
