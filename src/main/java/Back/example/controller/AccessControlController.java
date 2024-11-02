package Back.example.controller;

import Back.example.model.User;
import Back.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccessControlController {

    private final UserService userService;

    @Autowired
    public AccessControlController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll(); // Cambiado para coincidir con UserService
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.save(user); // Cambiado para coincidir con UserService
    }
}
