package Back.example.rest;

import Back.example.model.Role;
import Back.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleRestController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id) {
        return roleService.findById(id);
    }

    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleService.save(role);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteById(id);
    }
}
