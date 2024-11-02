package Back.example.controller;

import Back.example.model.User;
import Back.example.model.Role; // Asegúrate de tener la clase Role correctamente configurada
import Back.example.service.UserService;
import Back.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;
    private final RoleService roleService; // Para obtener roles disponibles

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users"; // Muestra el archivo users.html en templates
    }

    @PostMapping("/users/add")
    public String addUser(@RequestParam String username, @RequestParam String password, @RequestParam String role) {
        Role userRole = roleService.findByName(role)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + role));
        User newUser = new User(username, password, userRole);
        userService.save(newUser);
        return "redirect:/users"; // Redirige a la página de usuarios después de agregar
    }
}
