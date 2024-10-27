package org.example.pages;

import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccesControlPage {

    private final UserService userService;

    @Autowired
    public AccesControlPage(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/access-control")
    public String renderAccessControlPage(Model model) {
        model.addAttribute("pageTitle", "Control de Acceso");
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("roles", userService.getAllRoles());
        return "pages/access-control";  // Apunta a un archivo access-control.html en templates/pages/
    }
}
