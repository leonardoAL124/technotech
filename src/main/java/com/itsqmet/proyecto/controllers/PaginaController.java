
package com.itsqmet.proyecto.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller

public class PaginaController {
    
    @GetMapping("/")
    public String home(){
        return "login";
    }
    
    @GetMapping("/principal")
    public String principal(){
        return "principal";
    }
    
}
