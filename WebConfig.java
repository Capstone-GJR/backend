package com.capstone.backend.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Override
       public void addCorsMappings(CorsRegistry registry) {
           WebConfigProperties.Cors cors = WebConfigProperties.getCors();
           registry.addMapping("/**")
             .allowedOrigins(cors.getAllowedOrigins())
             .allowedMethods(cors.getAllowedMethods())
             .maxAge(cors.getMaxAge())
             .allowedHeaders(cors.getAllowedHeaders())
             .exposedHeaders(cors.getExposedHeaders());
       }
}
