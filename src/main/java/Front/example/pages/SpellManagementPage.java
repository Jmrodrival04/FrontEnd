package Front.example.pages;

import Front.example.services.SpellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpellManagementPage {

    private final SpellService spellService;

    @Autowired
    public SpellManagementPage(SpellService spellService) {
        this.spellService = spellService;
    }

    @GetMapping("/spells")
    public String renderSpellManagementPage(Model model) {
        model.addAttribute("pageTitle", "Gestión de Hechizos");
        model.addAttribute("spells", spellService.getAllSpells());
        return "pages/spell-management";  // Apunta a un archivo spell-management.html en templates/pages/
    }
}
