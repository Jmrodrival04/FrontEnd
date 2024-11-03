package Back.example.service;

import Back.example.annotations.AuditableAction;
import Back.example.annotations.SecuredAction;
import Back.example.model.Spell;
import Back.example.repos.SpellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service
public class SpellService {

    private static final Logger logger = Logger.getLogger(SpellService.class.getName());

    private final SpellRepository spellRepository;

    @Autowired
    public SpellService(SpellRepository spellRepository) {
        this.spellRepository = spellRepository;
    }

    @SecuredAction("ROLE_ADMIN")
    @AuditableAction(actionType = "CREATE")
    @Transactional
    public Spell saveSpell(Spell spell) {
        logger.info("Guardando nuevo hechizo: " + spell.getName());
        return spellRepository.save(spell);
    }

    @SecuredAction("ROLE_USER")
    @AuditableAction(actionType = "READ")
    public List<Spell> findAllSpells() {
        logger.info("Buscando todos los hechizos");
        return spellRepository.findAll();
    }

    @SecuredAction("ROLE_ADMIN")
    @AuditableAction(actionType = "DELETE")
    @Transactional
    public void deleteSpell(Long id) {
        logger.info("Eliminando hechizo con ID: " + id);
        spellRepository.findById(id)
                .ifPresentOrElse(
                        spell -> spellRepository.deleteById(id),
                        () -> { throw new RuntimeException("Hechizo no encontrado con ID: " + id); }
                );
    }

    @SecuredAction("ROLE_USER")
    @AuditableAction(actionType = "READ")
    public Spell findById(Long id) {
        logger.info("Buscando hechizo con ID: " + id);
        return spellRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hechizo no encontrado con ID: " + id));
    }
}
