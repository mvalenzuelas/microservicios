package com.example.calculatenewpriceservice.config;

import com.example.calculatenewpriceservice.services.CalculateNewPriceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculateNewPriceServiceConfig {
    @Bean
    public CalculateNewPriceService calculateNewPriceService(){return new CalculateNewPriceService();}
}
