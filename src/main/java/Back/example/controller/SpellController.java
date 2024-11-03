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

@Controller
public class SpellController {

    private final SpellService spellService;

    @Autowired
    public SpellController(SpellService spellService) {
        this.spellService = spellService;
    }

    @GetMapping("/spells")
    public String getSpells(Model model) {
        model.addAttribute("spells", spellService.findAllSpells());
        return "spells";
    }

    @PostMapping("/spells/add")
    public String addSpell(@RequestParam String name, @RequestParam String type, @RequestParam String effect) {
        Spell newSpell = new Spell(name, type, effect);
        spellService.saveSpell(newSpell);
        return "redirect:/spells";
    }

    @PostMapping("/spells/delete/{id}")
    public String deleteSpell(@PathVariable Long id) {
        spellService.deleteSpell(id);
        return "redirect:/spells";
    }
}
