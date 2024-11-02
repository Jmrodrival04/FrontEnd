package Front.example.services;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuditService {

    private List<String> auditLogs;

    public AuditService() {
        this.auditLogs = new ArrayList<>();
    }

    // Agregar un evento de auditoría
    public void logEvent(String event) {
        auditLogs.add(event);
    }

    // Obtener todos los eventos de auditoría
    public List<String> getAuditLogs() {
        return new ArrayList<>(auditLogs);
    }

    // Limpiar los logs de auditoría
    public void clearLogs() {
        auditLogs.clear();
    }
}
