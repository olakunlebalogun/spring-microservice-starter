package com.olakunle.productservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class TestConfig {
    @Bean
    public ObjectMapper objectMapper () {
        return new ObjectMapper();
    }
}
