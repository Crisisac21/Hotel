package com.ups.hotel.config;

<<<<<<< HEAD
import org.springdoc.core.GroupedOpenApi;
=======
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
>>>>>>> 660b226 (Add OpenAPI metadata and grouped API docs)
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

    @Bean
    public OpenAPI hotelOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Hotel Reservas API")
                        .description("API for hotel reservation management")
                        .version("1.0.0"));
    }
}
