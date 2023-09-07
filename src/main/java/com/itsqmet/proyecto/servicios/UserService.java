package com.itsqmet.proyecto.servicios;

import com.itsqmet.proyecto.entidades.Usuario;
import com.itsqmet.proyecto.repositorios.UsuarioRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class UserService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);

        UserDetails userDetails = new User(usuario.getUsername(), usuario.getContraseniaUsr(), convertToAuthorities(usuario.getRolUsr()));

        return userDetails;
    }

    public Collection<GrantedAuthority> convertToAuthorities(String roleString) {
        // Crea un objeto GrantedAuthority para el rol
        GrantedAuthority authority = new SimpleGrantedAuthority(roleString);

        // Crea una colección con un solo elemento (el rol)
        return Collections.singletonList(authority);
    }
}
