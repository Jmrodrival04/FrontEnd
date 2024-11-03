package Back.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // Cambia este origen al dominio permitido en producción
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Especifica los métodos permitidos
                .allowedHeaders("*")
                .allowCredentials(true); // Permitir credenciales, si es necesario
    }
}
