package com.projetmeteo.meteo.Gestion;

import com.projetmeteo.meteo.ClasseMeteo.WeatherData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
    //WeatherData findByNom(String id);
}