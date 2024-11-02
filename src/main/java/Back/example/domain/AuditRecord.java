package Back.example.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action; // Descripción de la acción realizada
    private String performedBy; // Usuario que realizó la acción
    private LocalDateTime timestamp; // Fecha y hora de la acción

    // Constructor adicional sin id para crear nuevos registros de auditoría
    public AuditRecord(String action, String performedBy) {
        this.action = action;
        this.performedBy = performedBy;
        this.timestamp = LocalDateTime.now();
    }
}
