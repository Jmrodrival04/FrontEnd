package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocumentationController {

    @GetMapping("/model")
    public String modelDocumentation() {
        return "model"; // Apunta al archivo model.html en templates
    }

    @GetMapping("/domain")
    public String domainDocumentation() {
        return "domain"; // Apunta al archivo domain.html en templates
    }

    @GetMapping("/util")
    public String utilDocumentation() {
        return "util"; // Apunta al archivo util.html en templates
    }
}
