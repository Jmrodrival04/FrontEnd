package Back.example.model;

import Back.example.util.Auditable;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @ManyToOne
    private Role role; // Relación con la entidad Role

    // Campos de auditoría
    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;

    // Constructor sin argumentos requerido por JPA
    public User() {
    }

    // Constructor completo
    public User(Long id, String username, String password, Role role, String createdBy, LocalDateTime createdDate, String lastModifiedBy, LocalDateTime lastModifiedDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }

    // Constructor personalizado para crear un nuevo usuario
    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.createdDate = LocalDateTime.now();
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    // Implementación de los métodos de auditoría
    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    @Override
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    @Override
    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    // Método toString para depuración
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", role=" + role +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
