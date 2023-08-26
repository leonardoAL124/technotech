
package com.itsqmet.proyecto.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
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
    private String userUsr;
    private String contraseniaUsr;
    
}
