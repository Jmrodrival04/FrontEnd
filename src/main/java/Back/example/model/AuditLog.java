package Back.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La acción es obligatoria")
    private String action;

    @NotBlank(message = "El campo 'realizado por' es obligatorio")
    private String performedBy;

    private LocalDateTime timestamp;

    // Constructor sin argumentos requerido por JPA
    public AuditLog() {
    }

    // Constructor completo
    public AuditLog(Long id, String action, String performedBy, LocalDateTime timestamp) {
        this.id = id;
        this.action = action;
        this.performedBy = performedBy;
        this.timestamp = timestamp;
    }

    // Constructor para crear nuevos registros de auditoría
    public AuditLog(String action, String performedBy) {
        this.action = action;
        this.performedBy = performedBy;
        this.timestamp = LocalDateTime.now(); // Configurar la fecha y hora actuales
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // Método toString opcional para facilitar la depuración
    @Override
    public String toString() {
        return "AuditLog{" +
                "id=" + id +
                ", action='" + action + '\'' +
                ", performedBy='" + performedBy + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
