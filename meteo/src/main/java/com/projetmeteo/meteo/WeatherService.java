package com.projetmeteo.meteo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    @Autowired
    private WeatherDataRepository weatherRepository;

    public void saveWeatherData(WeatherData weatherData) {
        weatherRepository.save(weatherData);
    }
}
