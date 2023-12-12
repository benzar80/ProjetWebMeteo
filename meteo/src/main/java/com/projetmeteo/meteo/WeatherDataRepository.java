package com.projetmeteo.meteo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
}