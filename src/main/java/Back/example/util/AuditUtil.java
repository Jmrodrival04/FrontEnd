package Back.example.util;

import Back.example.model.AuditLog;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditUtil {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Método para crear un registro de auditoría básico
    public static AuditLog createAuditLog(String action, String performedBy) {
        AuditLog auditLog = new AuditLog();
        auditLog.setAction(action);
        auditLog.setPerformedBy(performedBy);
        auditLog.setTimestamp(LocalDateTime.now());
        return auditLog;
    }

    // Método para formatear una entrada de auditoría como una cadena legible
    public static String formatAuditLog(AuditLog auditLog) {
        return String.format("Action: %s, Performed By: %s, Timestamp: %s",
                auditLog.getAction(),
                auditLog.getPerformedBy(),
                formatDateTime(auditLog.getTimestamp()));
    }

    // Método para formatear la fecha y hora de una entrada de auditoría
    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTime != null ? dateTime.format(formatter) : "N/A";
    }
}
