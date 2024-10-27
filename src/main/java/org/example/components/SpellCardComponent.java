package org.example.components;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/spell-card")
public class SpellCardComponent {

    private String name;
    private String type;
    private String effect;

    // Constructor con los datos del hechizo
    public SpellCardComponent(String name, String type, String effect) {
        this.name = name;
        this.type = type;
        this.effect = effect;
    }

    @GetMapping
    public String renderSpellCard(Model model) {
        model.addAttribute("spellName", name);
        model.addAttribute("spellType", type);
        model.addAttribute("spellEffect", effect);
        return "components/spell-card";  // Aquí debería apuntar a un archivo spell-card.html en templates
    }
}
