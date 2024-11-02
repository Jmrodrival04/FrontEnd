package Back.example.repos;

import Back.example.model.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

    // Ejemplo de método personalizado: encontrar registros de auditoría por usuario
    List<AuditLog> findByPerformedBy(String performedBy);
}
