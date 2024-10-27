package org.example.services;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {

    private List<String> notifications;

    public NotificationService() {
        this.notifications = new ArrayList<>();
    }

    // Agregar una nueva notificación
    public void addNotification(String message) {
        notifications.add(message);
    }

    // Obtener todas las notificaciones
    public List<String> getNotifications() {
        return new ArrayList<>(notifications);
    }

    // Limpiar todas las notificaciones
    public void clearNotifications() {
        notifications.clear();
    }
}
