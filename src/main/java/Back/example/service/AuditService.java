package Back.example.service;

import Back.example.model.AuditLog;
import Back.example.repos.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service
public class AuditService {

    private static final Logger logger = Logger.getLogger(AuditService.class.getName());

    @Autowired
    private AuditLogRepository auditLogRepository;

    // Obtiene todos los registros de auditoría
    public List<AuditLog> findAll() {
        logger.info("Buscando todos los registros de auditoría");
        return auditLogRepository.findAll();
    }

    // Busca un registro de auditoría por ID
    public AuditLog findById(Long id) {
        logger.info("Buscando registro de auditoría por ID: " + id);
        return auditLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de auditoría no encontrado con ID: " + id));
    }

    // Guarda un nuevo registro de auditoría
    @Transactional
    public AuditLog save(AuditLog auditLog) {
        logger.info("Guardando nuevo registro de auditoría: " + auditLog.getAction());
        return auditLogRepository.save(auditLog);
    }

    // Elimina un registro de auditoría por ID
    @Transactional
    public void deleteById(Long id) {
        logger.info("Eliminando registro de auditoría con ID: " + id);
        if (auditLogRepository.existsById(id)) {
            auditLogRepository.deleteById(id);
        } else {
            throw new RuntimeException("Registro de auditoría no encontrado con ID: " + id);
        }
    }
}
