package Back.example.aspects;

import Back.example.annotations.AuditableAction;
import Back.example.model.AuditLog;
import Back.example.service.AuditService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Aspect
@Component
public class AuditAspect {

    private final AuditService auditService;

    @Autowired
    public AuditAspect(AuditService auditService) {
        this.auditService = auditService;
    }

    @After("@annotation(auditableAction)")
    public void logAuditAction(JoinPoint joinPoint, AuditableAction auditableAction) {
        String actionType = auditableAction.actionType();
        String description = auditableAction.description().isEmpty() ? "Acción ejecutada" : auditableAction.description();

        // Información del usuario que realizó la acción (esto es solo un ejemplo, ajustar según tu autenticación)
        String performedBy = "UsuarioDesconocido"; // Sustituir por el sistema real de autenticación
        LocalDateTime timestamp = LocalDateTime.now();

        // Crear y guardar el registro de auditoría
        AuditLog auditLog = new AuditLog(actionType, performedBy, description, timestamp);
        auditService.save(auditLog);
    }
}
