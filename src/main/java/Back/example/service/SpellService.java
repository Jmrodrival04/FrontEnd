package Back.example.service;

import Back.example.model.Spell;
import Back.example.repos.SpellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpellService {

    @Autowired
    private SpellRepository spellRepository;

    public List<Spell> findAll() {
        return spellRepository.findAll();
    }

    public Spell findById(Long id) {
        return spellRepository.findById(id).orElse(null);
    }

    public Spell save(Spell spell) {
        return spellRepository.save(spell);
    }

    public void deleteById(Long id) {
        spellRepository.deleteById(id);
    }
}
