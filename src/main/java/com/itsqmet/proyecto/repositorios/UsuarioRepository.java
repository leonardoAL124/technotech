
package com.itsqmet.proyecto.repositorios;

import com.itsqmet.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Usuario findByUsername(String username);
}
