package Back.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public String appName() {
        return "Magic Management System";
    }

    // Aquí puedes añadir otros beans que se requieran en toda la aplicación.
}
