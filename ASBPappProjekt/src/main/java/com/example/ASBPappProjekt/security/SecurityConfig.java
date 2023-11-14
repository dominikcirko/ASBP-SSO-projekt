package com.example.ASBPappProjekt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .oauth2Client(Customizer.withDefaults())
                .oauth2Login(oauth2login -> oauth2login
                        .tokenEndpoint(Customizer.withDefaults())
                        .userInfoEndpoint(Customizer.withDefaults()));

        http
                .sessionManagement(sessionmgmt -> sessionmgmt
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS));

        http
                .authorizeHttpRequests(auth -> auth.anyRequest().fullyAuthenticated());
        return http.build();
    }
}
