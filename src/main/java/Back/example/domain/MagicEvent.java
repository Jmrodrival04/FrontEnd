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
public class MagicEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Nombre del evento mágico
    private String type; // Tipo de evento (por ejemplo, "hechizo", "encantamiento")
    private int intensityLevel; // Nivel de intensidad o potencia del evento
    private String location; // Ubicación donde se realiza el evento mágico
}
