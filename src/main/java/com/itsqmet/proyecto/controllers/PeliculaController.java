
package com.itsqmet.proyecto.controllers;

import com.itsqmet.proyecto.entidades.Pelicula;
import com.itsqmet.proyecto.repositorios.PeliculaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller

public class PeliculaController {
    @Autowired
    PeliculaRepository peliculaRepository;
    
    //READ
    @GetMapping("/pelicula")
    public String listarPelicula(Model model) {
        List<Pelicula> peliculas = peliculaRepository.findAll();
        model.addAttribute("peliculas", peliculas);
        return "pelicula/pelicula";
    }
    
    //CREATE
    @GetMapping("/pelicula/formulario")
    public String form(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "pelicula/formulario";
    }

    @PostMapping("/pelicula/formulario")
    public String crearPelicula(Pelicula pelicula) {
        peliculaRepository.save(pelicula);
        return "redirect:/pelicula";
    }
    
    //UPDATE
    @GetMapping("/pelicula/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Pelicula> pelicula = peliculaRepository.findById(id);
        model.addAttribute("pelicula", pelicula);
        return "/pelicula/formulario";
    }
    
    //DELETE
    @GetMapping("/pelicula/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        peliculaRepository.deleteById(id);
        return "redirect:/pelicula";
    }
}
