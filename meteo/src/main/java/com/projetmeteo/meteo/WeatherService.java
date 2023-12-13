package com.projetmeteo.meteo;

import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    @Autowired
    private WeatherDataRepository weatherRepository;

    public void saveWeatherData(WeatherData weatherData) {
        weatherRepository.save(weatherData);
    }

    public void saveDownload(String city){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            WeatherDataResponse weatherDataResponse = objectMapper.readValue(new URL("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" + city + "/next7days?unitGroup=metric&key=BW4J9URLRRGB6833JQ5GP9268&include=days&elements=datetime,temp,tempmax,tempmin,humidity,precipprob,windspeed,sunrise,sunset,conditions,description&lang=fr&contentType=json"), WeatherDataResponse.class);
            System.out.println("URL: https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" + city + "/next7days?unitGroup=metric&key=BW4J9URLRRGB6833JQ5GP9268&include=days&elements=datetime,temp,tempmax,tempmin,humidity,precipprob,windspeed,sunrise,sunset,conditions,description&lang=fr&contentType=json");
            // Utilisez les données récupérées comme nécessaire
            System.out.println("Resolved Address: " + weatherDataResponse.getResolvedAddress());
            System.out.println("Latitude: " + weatherDataResponse.getLatitude());
            System.out.println("Longitude: " + weatherDataResponse.getLongitude());
      
            for (WeatherDay day : weatherDataResponse.getDays()) {
                System.out.println("Date: " + day.getDatetime());
                System.out.println("Max Temperature: " + day.getTempMax());
                System.out.println("Min Temperature: " + day.getTempMin());
                System.out.println("Levé du soleil : " + day.getSunrise());
                System.out.println("Couché du soleil : " + day.getSunset());
                System.out.println("Conditions : " + day.getConditions());
                System.out.println("Description : " + day.getDescription());
                // Ajoutez d'autres données nécessaires...
                System.out.println("--------------------");
      
                weatherRepository.save(new WeatherData(day.getDatetime(), day.getTemp(), day.getTempMax(), day.getTempMin(), day.getHumidity(), day.getPrecipProb(), day.getWindSpeed(), day.getSunrise(), day.getSunset(), day.getConditions(), day.getDescription()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
