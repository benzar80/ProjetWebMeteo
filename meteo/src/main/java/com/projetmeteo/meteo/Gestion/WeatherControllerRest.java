package com.projetmeteo.meteo.Gestion;

import java.util.List;

import com.projetmeteo.meteo.ClasseMeteo.WeatherDataCity;
import com.projetmeteo.meteo.ClasseMeteo.WeatherDataCurrentConditions;
import com.projetmeteo.meteo.ClasseMeteo.WeatherDataDay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.model.Model;

@RestController
public class WeatherControllerRest {
    @Autowired
	    WeatherDataRepository repo;

    @PostMapping("/sendWeatherData")
        public void sendWeatherData(
            @RequestParam Long id,
            @RequestParam Double temp,
            @RequestParam Double humidity,
            @RequestParam Double precipprob,
            @RequestParam Double windspeed,
            @RequestParam String conditions,
            @RequestParam String sunrise,
            @RequestParam String sunset,
            Model model) {
            try {
                
                WeatherDataCity weatherData = repo.findById(id).get();
                WeatherDataCurrentConditions weatherDataCurrent = weatherData.weatherDataCurrentConditions();
                weatherDataCurrent.setTemp(temp);
                weatherDataCurrent.setHumidity(humidity);
                weatherDataCurrent.setPrecipprob(precipprob);
                weatherDataCurrent.setWindspeed(windspeed);
                weatherDataCurrent.setConditions(conditions);
                weatherDataCurrent.setSunrise(sunrise);
                weatherDataCurrent.setSunset(sunset);
                repo.save(weatherData);
                System.out.println("Données mise à jour avec succès !");
                
                
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }

        @PostMapping("/updateWeatherData2")
        public void sendWeatherData2(
            @RequestParam Long id,
            @RequestParam int idDay,
            @RequestParam String column,
            @RequestParam Double value,
            Model model) {
            try {

                WeatherDataCity weatherData = repo.findById(id).get();
                WeatherDataDay weatherDataDayNew = weatherData.getWeatherDay().get(idDay);
                
                switch (column) {
                    case "temp":
                        weatherDataDayNew.setTemp(value);
                        break;
                    case "tempmax":
                        weatherDataDayNew.setTempmax(value);
                        break;
                    case "tempmin":
                        weatherDataDayNew.setTempmin(value);
                        break;
                    case "humidity":
                        weatherDataDayNew.setHumidity(value);
                        break;
                    case "precipprob":
                        weatherDataDayNew.setPrecipprob(value);
                        break;
                    case "windspeed":
                        weatherDataDayNew.setWindspeed(value);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid column name: " + column);
                }
                repo.save(weatherData);
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
}