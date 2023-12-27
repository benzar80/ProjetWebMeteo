package com.projetmeteo.meteo.Gestion;

import java.util.List;

import com.projetmeteo.meteo.ClasseMeteo.WeatherDataCity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface WeatherDataRepository extends JpaRepository<WeatherDataCity, Long> {
    List<WeatherDataCity> findAllByaddress(String address);
    List<WeatherDataCity> findAll();
}