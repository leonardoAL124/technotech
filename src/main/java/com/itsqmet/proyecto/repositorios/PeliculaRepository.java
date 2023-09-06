
package com.itsqmet.proyecto.repositorios;

import com.itsqmet.proyecto.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>{
    
}
