package Back.example.repos;

import Back.example.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    // Encuentra un rol por su nombre
    Optional<Role> findByName(String name);
}
