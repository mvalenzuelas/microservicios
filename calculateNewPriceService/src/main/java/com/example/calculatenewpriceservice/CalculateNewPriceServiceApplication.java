package com.example.calculatenewpriceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.calculatenewpriceservice"})
public class CalculateNewPriceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculateNewPriceServiceApplication.class, args);
    }

}
