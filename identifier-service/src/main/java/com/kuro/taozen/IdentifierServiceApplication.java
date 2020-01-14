package com.kuro.taozen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class IdentifierServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdentifierServiceApplication.class, args);
    }

}
