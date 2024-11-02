package Back.example.controller;

import Back.example.model.User;
import Back.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users"; // Muestra el archivo users.html en templates
    }

    @PostMapping("/users/add")
    public String addUser(@RequestParam String username, @RequestParam String role) {
        userService.addUser(new User(username, role));
        return "redirect:/users"; // Redirige a la página de usuarios después de agregar
    }
}
