package Back.example.aspects;

import Back.example.annotations.SecuredAction;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    @Before("@annotation(securedAction)")
    public void checkPermission(SecuredAction securedAction) {
        // Obtener el usuario autenticado
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!(principal instanceof UserDetails)) {
            throw new SecurityException("Usuario no autenticado");
        }

        UserDetails userDetails = (UserDetails) principal;
        String requiredRole = securedAction.value();

        // Comprobar si el usuario tiene el rol necesario
        if (userDetails.getAuthorities().stream().noneMatch(
                authority -> authority.getAuthority().equals(requiredRole))) {
            throw new SecurityException("Permisos insuficientes para realizar esta acción");
        }
    }
}
