package Back.example.repos;

import Back.example.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    // Ejemplo de método personalizado: encontrar rol por nombre
    Role findByRoleName(String roleName);
}
