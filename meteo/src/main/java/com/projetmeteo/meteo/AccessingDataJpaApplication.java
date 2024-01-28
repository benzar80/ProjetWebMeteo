package com.projetmeteo.meteo;

import com.projetmeteo.meteo.Gestion.WeatherDataRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Annotation indiquant que cette classe est une application Spring Boot
@SpringBootApplication
public class AccessingDataJpaApplication {

    // Création d'un logger pour cette classe
    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    // Injection automatique du WeatherDataRepository pour les opérations de base de données
    @Autowired
    private WeatherDataRepository repo;

    // Point d'entrée principal de l'application Spring Boot
    public static void main(String[] args) {
         // Lance l'application Spring Boot
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }
}
