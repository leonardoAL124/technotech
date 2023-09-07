
package com.itsqmet.proyecto.controllers;

import com.itsqmet.proyecto.entidades.Usuario;
import com.itsqmet.proyecto.repositorios.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller

public class UsuarioController {
    @Autowired 
    UsuarioRepository usuarioRepository;
    
    //READ
    @GetMapping("/usuario")
    public String listarUsuario(Model model) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuario/usuario";
    }
    
    //CREATE - USUARIO
    @GetMapping("/registro")
    public String regis(Model model){
        model.addAttribute("usuario", new Usuario());
        return "registrarse";
    }
    
    @PostMapping("/registro")
    public String crearUsuario(Usuario user){
        Usuario usuario1 = new Usuario();
        usuario1.setIdUsr(user.getIdUsr());
        usuario1.setEmailUsr(user.getEmailUsr());
        usuario1.setNombreUsr(user.getNombreUsr());
        usuario1.setApellidoUsr(user.getApellidoUsr());
        usuario1.setFecNacUsr(user.getFecNacUsr());
        usuario1.setUsername(user.getUsername());
        usuario1.setContraseniaUsr(user.getContraseniaUsr());
        usuario1.setRolUsr(user.getRolUsr());
        usuarioRepository.save(usuario1);
        return "redirect:/";
    }
    
    //CREATE - ADMIN
    @GetMapping("/usuario/formulario")
    public String regisUserAdmin(Model model){
        model.addAttribute("usuario1", new Usuario());
        return "/usuario/formulario";
    }
    
    @PostMapping("/usuario/formulario")
    public String crearUsuarioAdmin(Usuario user){
        Usuario usuario1 = new Usuario();
        usuario1.setIdUsr(user.getIdUsr());
        usuario1.setEmailUsr(user.getEmailUsr());
        usuario1.setNombreUsr(user.getNombreUsr());
        usuario1.setApellidoUsr(user.getApellidoUsr());
        usuario1.setFecNacUsr(user.getFecNacUsr());
        usuario1.setUsername(user.getUsername());
        usuario1.setContraseniaUsr(user.getContraseniaUsr());
        usuario1.setRolUsr(user.getRolUsr());
        usuarioRepository.save(usuario1);
        return "redirect:/usuario";
    }
    
    //UPDATE
    @GetMapping("/usuario/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        model.addAttribute("usuario1", usuario);
        return "/usuario/formulario";
    }
    
    //DELETE
    @GetMapping("/usuario/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        usuarioRepository.deleteById(id);
        return "redirect:/usuario";
    }
}
