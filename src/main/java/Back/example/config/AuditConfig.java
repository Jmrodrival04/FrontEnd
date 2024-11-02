package Back.example.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AuditConfig {

    private static final Logger auditLogger = LoggerFactory.getLogger("AuditLogger");

    @After("execution(* Back.example.service.*.*(..))")
    public void logAuditTrail(JoinPoint joinPoint) {
        auditLogger.info("Auditoría: método ejecutado - " + joinPoint.getSignature().getName());
    }
}
