package Back.example.service;

import Back.example.model.User;
import Back.example.repos.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UserService {

    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Encuentra todos los usuarios
    public List<User> findAll() {
        logger.info("Buscando todos los usuarios");
        return userRepository.findAll();
    }

    // Encuentra un usuario por su ID y lanza una excepción si no se encuentra
    public User findById(Long id) {
        logger.info("Buscando usuario por ID: " + id);
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    // Guarda un nuevo usuario
    public User save(User user) {
        logger.info("Guardando nuevo usuario: " + user.getUsername());
        return userRepository.save(user);
    }

    // Actualiza un usuario existente
    @Transactional
    public User updateUser(Long id, User updatedUser) {
        logger.info("Actualizando usuario con ID: " + id);
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(updatedUser.getUsername());
                    user.setPassword(updatedUser.getPassword());
                    user.setRole(updatedUser.getRole());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    // Elimina un usuario por su ID
    public void deleteById(Long id) {
        logger.info("Eliminando usuario con ID: " + id);
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
    }
}
