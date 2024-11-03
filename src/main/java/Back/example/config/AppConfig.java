package Back.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public String appName() {
        return "Magic Management System";
    }

    @Bean
    public String dateFormat() {
        return "yyyy-MM-dd HH:mm:ss";
    }

    @Bean
    public int maxLoginAttempts() {
        return 5;
    }

    @Bean
    public int defaultPageSize() {
        return 20; // Tamaño de página por defecto para la paginación
    }

    @Bean
    public String defaultTimeZone() {
        return "UTC"; // Zona horaria por defecto para registros de auditoría y logs
    }
}
