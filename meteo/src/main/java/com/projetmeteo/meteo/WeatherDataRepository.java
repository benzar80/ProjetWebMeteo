package com.projetmeteo.meteo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface WeatherDataRepository extends CrudRepository<WeatherData, Long> {
  
}