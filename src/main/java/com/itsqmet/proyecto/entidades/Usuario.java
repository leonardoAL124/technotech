
package com.itsqmet.proyecto.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;
@Data
@Entity

public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUsr;
    private String emailUsr;
    private String nombreUsr;
    private String apellidoUsr;
    private LocalDate fecNacUsr;
    private String username;
    private String contraseniaUsr;
    private String rolUsr;
    
    @JoinTable(
        name = "registro",
        joinColumns = @JoinColumn(name = "fk_usuario", nullable = false),
        inverseJoinColumns = @JoinColumn(name="fk_pelicula", nullable = false)
    )
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Pelicula> peliculas;
    
}
