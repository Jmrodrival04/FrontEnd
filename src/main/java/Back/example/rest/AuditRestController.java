package Back.example.rest;

import Back.example.model.AuditLog;
import Back.example.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit")
public class AuditRestController {

    private final AuditService auditService;

    @Autowired
    public AuditRestController(AuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping
    public List<AuditLog> getAllAuditLogs() {
        return auditService.findAll();
    }

    @GetMapping("/{id}")
    public AuditLog getAuditLogById(@PathVariable Long id) {
        return auditService.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de auditoría no encontrado con ID: " + id));
    }

    @PostMapping
    public AuditLog createAuditLog(@RequestBody AuditLog auditLog) {
        return auditService.save(auditLog);
    }

    @DeleteMapping("/{id}")
    public void deleteAuditLog(@PathVariable Long id) {
        auditService.deleteById(id);
    }
}
