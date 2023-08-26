
package com.itsqmet.proyecto.controllers;

import com.itsqmet.proyecto.entidades.Usuario;
import com.itsqmet.proyecto.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller

public class UsuarioController {
    @Autowired 
    UsuarioRepository usuarioRepository;
    
    @GetMapping("/registro")
    public String regis(Model model){
        model.addAttribute("usuario", new Usuario());
        return "registrarse";
    }
    
    @PostMapping("/registro")
    public String crear(Usuario user){
        usuarioRepository.save(user);
        return "redirect:/";
    }
}
