
package com.itsqmet.proyecto.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller

public class Principal {
    
    @GetMapping("/")
    public String home(){
        return "index";
    }
    
    @GetMapping("/usuario")
    public String usuario(){
        return "usuario";
    }
}
