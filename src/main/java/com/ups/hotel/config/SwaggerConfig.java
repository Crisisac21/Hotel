package com.ups.hotel.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi hotelApi() {
        return GroupedOpenApi.builder()
                .group("hotel-reservas")
                .pathsToMatch("/api/**")
                .build();
    }
}
