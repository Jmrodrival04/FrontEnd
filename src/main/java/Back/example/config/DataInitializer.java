package Back.example.config;

import Back.example.model.Role;
import Back.example.model.User;
import Back.example.repos.RoleRepository;
import Back.example.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initData(UserRepository userRepository, RoleRepository roleRepository) {
        return args -> {
            // Buscar roles, y si no existen, crearlos
            Role adminRole = roleRepository.findByName("ROLE_ADMIN").orElseGet(() -> roleRepository.save(new Role("ROLE_ADMIN")));
            Role userRole = roleRepository.findByName("ROLE_USER").orElseGet(() -> roleRepository.save(new Role("ROLE_USER")));

            // Buscar usuarios, y si no existen, crearlos con los roles encontrados
            if (userRepository.findByUsername("admin").isEmpty()) {
                userRepository.save(new User("admin", passwordEncoder.encode("admin123"), adminRole));
            }
            if (userRepository.findByUsername("user").isEmpty()) {
                userRepository.save(new User("user", passwordEncoder.encode("user123"), userRole));
            }
        };
    }
}
