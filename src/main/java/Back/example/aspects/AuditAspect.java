package Back.example.aspects;

import Back.example.annotations.AuditableAction;
import Back.example.model.AuditLog;
import Back.example.service.AuditService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class AuditAspect {

    @Autowired
    private AuditService auditService;

    @AfterReturning("@annotation(auditableAction)")
    public void logAuditEvent(JoinPoint joinPoint, AuditableAction auditableAction) {
        // Obtener el usuario autenticado
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = (principal instanceof UserDetails) ? ((UserDetails) principal).getUsername() : "Anonymous";

        // Crear y guardar el registro de auditoría
        AuditLog auditLog = new AuditLog();
        auditLog.setAction(auditableAction.actionType());
        auditLog.setPerformedBy(username);
        auditLog.setTimestamp(LocalDateTime.now());
        auditService.save(auditLog);
    }
}
