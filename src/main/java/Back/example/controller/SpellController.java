package Back.example.controller;

import Back.example.model.Spell;
import Back.example.service.SpellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spells") // Prefijo para todas las rutas de hechizos
public class SpellController {

    private final SpellService spellService;

    @Autowired
    public SpellController(SpellService spellService) {
        this.spellService = spellService;
    }

    @GetMapping
    public String getSpells(Model model) {
        model.addAttribute("spells", spellService.findAllSpells());
        return "spells";  // Carga el archivo spells.html desde /templates/
    }

    @PostMapping("/add")
    public String addSpell(@RequestParam String name, @RequestParam String type, @RequestParam String effect) {
        Spell newSpell = new Spell(name, type, effect);
        spellService.saveSpell(newSpell);
        return "redirect:/spells";
    }

    @PostMapping("/delete/{id}")
    public String deleteSpell(@PathVariable Long id) {
        spellService.deleteSpell(id);
        return "redirect:/spells";
    }
}
