package Back.example.controller;

import Back.example.model.User;
import Back.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/access-control") // Ruta base para evitar conflictos de rutas
public class AccessControlController {

    private final UserService userService;

    @Autowired
    public AccessControlController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }
}
