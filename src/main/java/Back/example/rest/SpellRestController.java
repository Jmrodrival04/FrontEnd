package Back.example.rest;

import Back.example.model.Spell;
import Back.example.service.SpellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spells")
public class SpellRestController {

    @Autowired
    private SpellService spellService;

    @GetMapping
    public List<Spell> getAllSpells() {
        return spellService.findAll();
    }

    @GetMapping("/{id}")
    public Spell getSpellById(@PathVariable Long id) {
        return spellService.findById(id);
    }

    @PostMapping
    public Spell createSpell(@RequestBody Spell spell) {
        return spellService.save(spell);
    }

    @DeleteMapping("/{id}")
    public void deleteSpell(@PathVariable Long id) {
        spellService.deleteById(id);
    }
}
