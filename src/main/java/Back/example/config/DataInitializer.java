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
            Role adminRole = new Role("ROLE_ADMIN");
            Role userRole = new Role("ROLE_USER");
            roleRepository.save(adminRole);
            roleRepository.save(userRole);

            User admin = new User("admin", passwordEncoder.encode("admin123"), adminRole);
            User user = new User("user", passwordEncoder.encode("user123"), userRole);
            userRepository.save(admin);
            userRepository.save(user);
        };
    }
}
