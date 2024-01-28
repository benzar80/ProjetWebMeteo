package com.projetmeteo.meteo;

import com.projetmeteo.meteo.Gestion.WeatherDataRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    @Autowired
    private WeatherDataRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }
}
