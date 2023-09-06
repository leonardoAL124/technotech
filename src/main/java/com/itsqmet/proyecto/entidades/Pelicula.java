
package com.itsqmet.proyecto.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.Data;
@Data
@Entity

public class Pelicula {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPel;
    private String nombrePel;
    private String categoriaPel;
    
    @ManyToMany(mappedBy = "peliculas")
    private List<Usuario> usuarios;
}
