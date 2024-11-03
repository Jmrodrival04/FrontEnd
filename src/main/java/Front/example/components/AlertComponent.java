package Front.example.components;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Component
@RequestMapping("/alerts")
public class AlertComponent {

    private final List<String> alerts = new LinkedList<>();

    // Método para añadir una alerta
    public synchronized void addAlert(String message) {
        alerts.add(message);
    }

    // Método para limpiar las alertas
    public synchronized void clearAlerts() {
        alerts.clear();
    }

    // Método para obtener las alertas en modo de solo lectura
    public List<String> getAlerts() {
        return Collections.unmodifiableList(alerts);
    }

    @GetMapping
    public String renderAlerts(Model model) {
        model.addAttribute("alerts", getAlerts());
        return "components/alerts"; // Apunta a un archivo alerts.html en templates
    }
}
