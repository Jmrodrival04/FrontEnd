package Front.example.components;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/navbar")
public class NavbarComponent {

    private static final String HOME_LINK = "/";
    private static final String SPELL_MANAGEMENT_LINK = "/spells";
    private static final String AUDIT_LOG_LINK = "/audit";
    private static final String ACCESS_CONTROL_LINK = "/access-control";

    @GetMapping
    public String renderNavbar(Model model) {
        model.addAttribute("homeLink", HOME_LINK);
        model.addAttribute("spellManagementLink", SPELL_MANAGEMENT_LINK);
        model.addAttribute("auditLogLink", AUDIT_LOG_LINK);
        model.addAttribute("accessControlLink", ACCESS_CONTROL_LINK);
        return "components/navbar";  // Apunta al archivo navbar.html en templates
    }
}
