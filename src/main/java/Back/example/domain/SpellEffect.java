package Back.example.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpellEffect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String spellName; // Nombre del hechizo
    private String description; // Descripción del efecto
    private int duration; // Duración en segundos
    private boolean isHarmful; // Indica si el efecto es dañino o no
}
