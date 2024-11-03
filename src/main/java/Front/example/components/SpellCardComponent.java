package Front.example.components;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/spell-card")
public class SpellCardComponent {

    @GetMapping
    public String renderSpellCard(
            @RequestParam String name,
            @RequestParam String type,
            @RequestParam String effect,
            Model model) {
        model.addAttribute("spellName", name);
        model.addAttribute("spellType", type);
        model.addAttribute("spellEffect", effect);
        return "components/spell-card"; // Apunta a un archivo spell-card.html en templates
    }
}
