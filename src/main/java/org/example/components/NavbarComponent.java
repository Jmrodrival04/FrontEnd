package org.example.components;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/navbar")
public class NavbarComponent {

    @GetMapping
    public String renderNavbar(Model model) {
        model.addAttribute("homeLink", "/");
        model.addAttribute("spellManagementLink", "/spells");
        model.addAttribute("auditLogLink", "/audit");
        model.addAttribute("accessControlLink", "/access-control");
        return "components/navbar";  // Aquí debería apuntar a un archivo navbar.html en templates
    }
}
