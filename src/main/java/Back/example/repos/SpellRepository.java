package Back.example.repos;

import Back.example.model.Spell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpellRepository extends JpaRepository<Spell, Long> {

    // Ejemplo de método personalizado: encontrar hechizos por tipo
    List<Spell> findByType(String type);
}
