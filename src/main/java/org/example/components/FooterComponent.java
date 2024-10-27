package org.example.components;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/footer")
public class FooterComponent {

    @GetMapping
    public String renderFooter(Model model) {
        model.addAttribute("currentYear", java.time.Year.now().getValue());
        model.addAttribute("footerMessage", "Sistema de Gestión Mágica © " + java.time.Year.now().getValue());
        return "components/footer";  // Aquí debería apuntar a un archivo footer.html en templates
    }
}
