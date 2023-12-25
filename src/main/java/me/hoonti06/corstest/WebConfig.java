package me.hoonti06.corstest;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.http.HttpMethod.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods(GET.name(), POST.name(), PATCH.name(), DELETE.name(), PUT.name())
                .allowedOrigins("http://localhost:8080")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}


