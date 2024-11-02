package Back.example.controller;

import Back.example.model.AuditLog;
import Back.example.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuditLogController {

    private final AuditService auditService;

    @Autowired
    public AuditLogController(AuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping("/audit")
    public String getAuditLogs(Model model) {
        model.addAttribute("auditLogs", auditService.findAll()); // Cambiado para coincidir con el método en AuditService
        return "audit-log"; // Muestra el archivo audit-log.html en templates
    }
}
