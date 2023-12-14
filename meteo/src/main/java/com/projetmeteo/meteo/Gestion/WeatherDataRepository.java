package com.projetmeteo.meteo.Gestion;

import com.projetmeteo.meteo.ClasseMeteo.WeatherDataCity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface WeatherDataRepository extends JpaRepository<WeatherDataCity, Long> {
    //WeatherData findByNom(String id);
}