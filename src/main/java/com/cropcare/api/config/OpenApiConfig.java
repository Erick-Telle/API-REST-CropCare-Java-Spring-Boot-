package com.cropcare.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI cropCareOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CropCare API")
                        .version("1.0.0")
                        .description("API REST para el catálogo de especies de plantas domésticas "
                                + "y factores de ajuste climático de la aplicación CropCare.")
                        .contact(new Contact()
                                .name("Equipo CropCare")
                                .email("cropcare@example.com")));
    }
}
