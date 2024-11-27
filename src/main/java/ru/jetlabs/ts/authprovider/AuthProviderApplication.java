package ru.jetlabs.ts.authprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AuthProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthProviderApplication.class, args);
    }
}
