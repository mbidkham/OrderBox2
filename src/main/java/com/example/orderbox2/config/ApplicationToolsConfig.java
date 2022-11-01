package com.example.orderbox2.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationToolsConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
