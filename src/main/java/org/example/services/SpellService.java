package org.example.services;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SpellService {

    private List<String> spells;

    public SpellService() {
        this.spells = new ArrayList<>();
        // Hechizos de ejemplo; reemplázalos con datos reales según sea necesario
        spells.add("Alohomora");
        spells.add("Expelliarmus");
        spells.add("Lumos");
    }

    // Obtener todos los hechizos
    public List<String> getAllSpells() {
        return new ArrayList<>(spells);
    }

    // Agregar un nuevo hechizo
    public void addSpell(String spell) {
        spells.add(spell);
    }

    // Eliminar un hechizo
    public void deleteSpell(String spell) {
        spells.remove(spell);
    }
}
