package com.projetmeteo.meteo;

import org.springframework.data.repository.CrudRepository;

public interface WeatherDataRepository extends CrudRepository<WeatherData, Long> {

}