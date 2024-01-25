package com.projetmeteo.meteo.Gestion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                    .csrf(AbstractHttpConfigurer::disable)
                    .securityMatchers( (matchers) -> matchers
                    .requestMatchers("/admin/**"))
                    .authorizeHttpRequests((authorize) -> authorize
                    .anyRequest().authenticated())
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login") // Page de connexion pour l'administration
                                .successForwardUrl("/login_success")
                                .failureForwardUrl("/login_failure")
                                .permitAll()
                )
                .logout(logout -> 
                                logout
                                    .logoutUrl("/logout") // URL pour déclencher la déconnexion
                                    .logoutSuccessUrl("/index") // URL vers laquelle rediriger après la déconnexion réussie
                                    .invalidateHttpSession(true)
                                    .deleteCookies("JSESSIONID")
                        
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
		UserDetails user =
			 User
                .withUsername("admin")
				.password(passwordEncoder.encode("admin"))
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user);
	}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
