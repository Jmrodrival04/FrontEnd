package Back.example.util;

import Back.example.model.AuditLog;
import java.time.LocalDateTime;

public class AuditUtil {

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
                DateUtil.formatDateTime(auditLog.getTimestamp()));
    }
}
