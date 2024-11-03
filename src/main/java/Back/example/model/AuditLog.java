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

    private String description; // Nuevo campo para la descripción de la acción

    private LocalDateTime timestamp;

    // Constructor sin argumentos requerido por JPA
    public AuditLog() {
    }

    // Constructor completo
    public AuditLog(String action, String performedBy, String description, LocalDateTime timestamp) {
        this.action = action;
        this.performedBy = performedBy;
        this.description = description;
        this.timestamp = timestamp;
    }

    // Constructor para crear un nuevo registro de auditoría con la hora actual
    public AuditLog(String action, String performedBy, String description) {
        this.action = action;
        this.performedBy = performedBy;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // Método toString para depuración
    @Override
    public String toString() {
        return "AuditLog{" +
                "id=" + id +
                ", action='" + action + '\'' +
                ", performedBy='" + performedBy + '\'' +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
