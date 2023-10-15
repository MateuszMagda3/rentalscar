package pl.rentalscar.rentalscarapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")       // Zezwól na wszystkie ścieżki
                        .allowedMethods("*")    // Zezwól na wszystkie metody HTTP: GET, POST, PUT, DELETE itp.
                        .allowedOrigins("*")    // Zezwól na wszystkie źródła
                        .allowedHeaders("*");   // Zezwól na wszystkie nagłówki
            }
        };
    }
}

