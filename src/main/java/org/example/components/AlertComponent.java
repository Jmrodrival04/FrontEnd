package org.example.components;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Component
@RequestMapping("/alerts")
public class AlertComponent {

    private final List<String> alerts = new ArrayList<>();

    // Método para añadir una alerta
    public void addAlert(String message) {
        alerts.add(message);
    }

    // Método para limpiar las alertas (opcional)
    public void clearAlerts() {
        alerts.clear();
    }

    @GetMapping
    public String renderAlerts(Model model) {
        model.addAttribute("alerts", alerts);
        return "components/alerts";  // Aquí debería apuntar a un archivo alerts.html en templates
    }
}
