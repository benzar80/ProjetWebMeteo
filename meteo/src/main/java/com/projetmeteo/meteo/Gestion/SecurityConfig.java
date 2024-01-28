package com.projetmeteo.meteo.Gestion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//Cette classe permet d'utiliser spring Security, la sécurité est plus renforcé sur notre site

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2/**") // Désactiver CSRF pour la console H2
                .disable()
            )
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/h2/**").permitAll() // Autoriser l'accès à la console H2
                .requestMatchers("/admin/**").hasRole("ADMIN") // Accès restreint à ADMIN pour /admin/**
                .anyRequest().permitAll() // Toutes les autres requêtes nécessitent une authentification
            )
            .formLogin(formLogin -> formLogin
                .loginPage("/login") // Page de connexion personnalisée
                .defaultSuccessUrl("/login_success", true) // Redirection en cas de succès
                .failureUrl("/login_failure") // Redirection en cas d'échec
                .permitAll() // Permettre l'accès à la page de connexion
            )
            .logout(logout -> logout
                .logoutUrl("/logout") // URL pour déclencher la déconnexion
                .logoutSuccessUrl("/index") // URL après déconnexion
                .invalidateHttpSession(true) // Invalider la session
                .deleteCookies("JSESSIONID") // Supprimer les cookies de session
            )
            .headers(headers -> headers
                .disable() 
            )
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        // Crée un utilisateur avec le rôle ADMIN
        UserDetails user = User.builder()
            .username("admin") // Définit le nom d'utilisateur comme "admin"
            .password(passwordEncoder.encode("admin")) // Encode le mot de passe "admin"
            .roles("ADMIN") // Attribue le rôle ADMIN à l'utilisateur
            .build(); // Construit l'objet UserDetails
    
        // Retourne un gestionnaire de détails d'utilisateur en mémoire avec l'utilisateur défini
        return new InMemoryUserDetailsManager(user);
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Retourne une instance de BCryptPasswordEncoder
        return new BCryptPasswordEncoder();
    }    
}
