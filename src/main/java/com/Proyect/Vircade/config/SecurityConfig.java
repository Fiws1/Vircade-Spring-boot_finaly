package com.Proyect.Vircade.config;

import com.Proyect.Vircade.modelo.Usuario;
import com.Proyect.Vircade.service.UsuarioService;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public FilterRegistrationBean hiddenHttpMethodFilter() {
        FilterRegistrationBean<HiddenHttpMethodFilter> filter = new FilterRegistrationBean<>(new HiddenHttpMethodFilter());
        filter.addUrlPatterns("/*");
        return filter;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(@NotNull AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsService(UsuarioService usuarioService) {
        return username -> {
            Usuario usuario = usuarioService.obtenerUsuarioPorCorreo(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
            List<SimpleGrantedAuthority> authorities = List.of(
                    new SimpleGrantedAuthority("ROLE_" + usuario.getRol().getNombre())
            );

            return new User(usuario.getCorreo(), usuario.getContrasenaUsu(),authorities);
        };
    }

    @Bean
    public SecurityFilterChain filterChain(@NotNull HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/js/**", "/css/**", "/img/**","/XML/**","/HTML5/**","/HTML/**","/jpg","/images/**","/jpeg").permitAll();
                    auth.requestMatchers("/", "/login/**", "/registro/**","/reset-password","/recover","/recover-passport","/reset-password-email","/recuperacion").permitAll(); // Páginas públicas
                    auth.requestMatchers("/admin/**","/view/**").hasRole("ADMIN"); // Solo administrador puede acceder
                    auth.requestMatchers("/cliente/**","/view/**").hasRole("CLIENTE");// Solo cliente puede acceder
                    auth.requestMatchers("/asesor/**","/view/**").hasRole("ASESOR"); // Solo asesor puede acceder
                    auth.anyRequest().authenticated(); // Cualquier otra requiere autenticación
                })
                .formLogin(form -> {
                    form.loginPage("/login"); // Página personalizada de login
                    form.defaultSuccessUrl("/home", true);
                    form.failureUrl("/login?error=true");
                    form.permitAll();
                })
                .logout(logout -> {
                    logout.logoutSuccessUrl("/login?logout=true");
                    logout.permitAll();
                })
                .build();
    }
}