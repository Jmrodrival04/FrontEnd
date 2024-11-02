package Front.example.pages;

import Front.example.services.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuditLogPage {

    private final AuditService auditService;

    @Autowired
    public AuditLogPage(AuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping("/audit")
    public String renderAuditLogPage(Model model) {
        model.addAttribute("pageTitle", "Registro de Auditoría");
        model.addAttribute("auditLogs", auditService.getAuditLogs());
        return "pages/audit-log";  // Apunta a un archivo audit-log.html en templates/pages/
    }
}
