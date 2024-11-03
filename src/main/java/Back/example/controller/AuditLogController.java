package Back.example.controller;

import Back.example.model.AuditLog;
import Back.example.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuditLogController {

    private final AuditService auditService;

    @Autowired
    public AuditLogController(AuditService auditService) {
        this.auditService = auditService;
    }

    /**
     * Método para manejar las solicitudes GET en "/audit"
     * que retorna la lista de registros de auditoría.
     */
    @GetMapping("/audit")
    public String getAuditLogs(Model model) {
        model.addAttribute("auditLogs", auditService.findAll());
        return "audit-log"; // Renderiza la vista audit-log.html en templates
    }
}
