package Back.example.aspects;

import Back.example.annotations.TransactionalAction;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Component
public class TransactionAspect {

    @Before("@annotation(transactionalAction)")
    @Transactional
    public void applyTransaction(TransactionalAction transactionalAction) {
        // Lógica adicional antes de iniciar la transacción (si es necesario)
        System.out.println("Iniciando transacción...");
    }
}
