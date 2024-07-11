package com.example.exportadores.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig implements WebMvcConfigurer {
    //Configuración de protección contra ataques XSS
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Utiliza el comodín /** para aplicar la configuración a todas las rutas
                .allowedOrigins("http://localhost:3000") // Permite solicitudes desde localhost:3000
                .allowedMethods("*") // Permitir todos los métodos HTTP
                .allowCredentials(true); // Permitir el envío de credenciales (por ejemplo, cookies)
    }
}
