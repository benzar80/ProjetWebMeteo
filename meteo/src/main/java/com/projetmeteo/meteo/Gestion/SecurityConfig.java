package com.projetmeteo.meteo.Gestion;


import java.util.concurrent.TimeUnit;

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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                    .csrf(AbstractHttpConfigurer::disable)
                        .securityMatchers( (matchers) -> matchers
                                .requestMatchers("/**"))
                    .authorizeHttpRequests((authorize) -> authorize
                            .requestMatchers("/").permitAll()
                    .anyRequest().authenticated())
                .formLogin((Customizer.withDefaults()));

        return http.build();
    }
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
		UserDetails user =
			 User
                .withUsername("ADMIN")
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
