package org.example.services;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<String> users;
    private List<String> roles;

    public UserService() {
        this.users = new ArrayList<>();
        this.roles = new ArrayList<>();
        // Ejemplos de usuarios y roles
        users.add("Harry Potter");
        users.add("Hermione Granger");

        roles.add("ADMIN");
        roles.add("USER");
    }

    // Obtener todos los usuarios
    public List<String> getAllUsers() {
        return new ArrayList<>(users);
    }

    // Obtener todos los roles
    public List<String> getAllRoles() {
        return new ArrayList<>(roles);
    }

    // Agregar un nuevo usuario
    public void addUser(String user) {
        users.add(user);
    }

    // Agregar un nuevo rol
    public void addRole(String role) {
        roles.add(role);
    }
}
