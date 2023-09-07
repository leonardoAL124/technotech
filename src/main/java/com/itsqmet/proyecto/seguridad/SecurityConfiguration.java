
package com.itsqmet.proyecto.seguridad;

import com.itsqmet.proyecto.servicios.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder1 = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder1;
    }

    protected  void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }
    
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() // Permitir recursos estáticos como CSS, JS, etc.
                                .requestMatchers("/principal").authenticated() // Requiere autenticación para /listaepisodios y /episodios
                                .requestMatchers("/usuario/formulario").hasAnyAuthority("ADMIN") // Requiere rol ADMIN para /admin/**
                                .anyRequest().permitAll() // Permite acceso no autenticado a todas las demás solicitudes
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/") // Especifica la página de inicio de sesión personalizada
                                .permitAll()
                                .loginProcessingUrl("/") // Ruta de procesamiento de inicio de sesión
                                .usernameParameter("username") // Nombre del campo de nombre de usuario en el formulario
                                .passwordParameter("contraseniaUsr") // Nombre del campo de contraseña en el formulario
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // URL para la acción de deslogueo
                        .logoutSuccessUrl("/") // Redirige después de deslogueo exitoso
                        .permitAll()
                )
                .httpBasic(withDefaults()) // Configura la autenticación básica con valores predeterminados
                .csrf().disable(); // Deshabilita CSRF
        return http.build();
    }
}
