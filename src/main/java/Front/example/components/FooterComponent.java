package Front.example.components;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Year;

@Component
@RequestMapping("/footer")
public class FooterComponent {

    private static final String BASE_FOOTER_MESSAGE = "Sistema de Gestión Mágica © ";

    @GetMapping
    public String renderFooter(Model model) {
        int currentYear = Year.now().getValue();
        model.addAttribute("currentYear", currentYear);
        model.addAttribute("footerMessage", BASE_FOOTER_MESSAGE + currentYear);
        return "components/footer";  // Aquí debería apuntar a un archivo footer.html en templates
    }
}
