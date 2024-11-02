package Back.example.repos;

import Back.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Ejemplo de método personalizado: encontrar usuario por nombre de usuario
    Optional<User> findByUsername(String username);
}
