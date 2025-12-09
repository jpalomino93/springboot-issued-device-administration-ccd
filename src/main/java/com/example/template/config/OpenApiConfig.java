package com.example.template.config;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class OpenApiConfig {
 @Bean
 public OpenAPI templateOpenAPI(){
     return new OpenAPI().info(new Info().title("Template API").version("v1"));
 }
}