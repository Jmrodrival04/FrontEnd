package Back.example.rest;

import Back.example.model.Spell;
import Back.example.service.SpellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spells")
public class SpellRestController {

    private final SpellService spellService;

    @Autowired
    public SpellRestController(SpellService spellService) {
        this.spellService = spellService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<Spell> getAllSpells() {
        return spellService.findAllSpells();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Spell createSpell(@RequestBody Spell spell) {
        return spellService.saveSpell(spell);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteSpell(@PathVariable Long id) {
        spellService.deleteSpell(id);
    }
}

