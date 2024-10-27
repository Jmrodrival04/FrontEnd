package org.example.pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {

    @GetMapping("/")
    public String renderHomePage(Model model) {
        model.addAttribute("pageTitle", "Inicio - Sistema de Gestión Mágica");
        model.addAttribute("welcomeMessage", "Bienvenido al Sistema de Gestión Mágica del Ministerio de Magia.");
        // Aquí podrías agregar más atributos de modelo como estadísticas generales
        return "pages/home";  // Apunta a un archivo home.html en templates/pages/
    }
}
