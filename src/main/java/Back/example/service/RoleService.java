package Back.example.service;

import Back.example.model.Role;
import Back.example.repos.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class RoleService {

    private static final Logger logger = Logger.getLogger(RoleService.class.getName());

    @Autowired
    private RoleRepository roleRepository;

    // Encuentra todos los roles
    public List<Role> findAll() {
        logger.info("Buscando todos los roles");
        return roleRepository.findAll();
    }

    // Encuentra un rol por su ID
    public Role findById(Long id) {
        logger.info("Buscando rol por ID: " + id);
        return roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con ID: " + id));
    }

    // Encuentra un rol por su nombre
    public Optional<Role> findByName(String name) {
        logger.info("Buscando rol por nombre: " + name);
        return roleRepository.findByName(name);
    }

    // Guarda un nuevo rol
    @Transactional
    public Role save(Role role) {
        logger.info("Guardando nuevo rol: " + role.getName());
        return roleRepository.save(role);
    }

    // Elimina un rol por su ID
    @Transactional
    public void deleteById(Long id) {
        logger.info("Eliminando rol con ID: " + id);
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
        } else {
            throw new RuntimeException("Rol no encontrado con ID: " + id);
        }
    }
}
