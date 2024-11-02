package Back.example.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AopConfig {

    private static final Logger logger = LoggerFactory.getLogger(AopConfig.class);

    @Before("execution(* Back.example.service.*.*(..))")
    public void beforeMethodExecution(JoinPoint joinPoint) {
        logger.info("Ejecutando método: " + joinPoint.getSignature().getName());
    }

    @After("execution(* Back.example.service.*.*(..))")
    public void afterMethodExecution(JoinPoint joinPoint) {
        logger.info("Finalizado método: " + joinPoint.getSignature().getName());
    }
}
