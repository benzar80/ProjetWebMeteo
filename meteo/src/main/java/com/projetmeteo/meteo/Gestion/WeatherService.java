package com.projetmeteo.meteo.Gestion;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projetmeteo.meteo.ClasseMeteo.WeatherDataCity;
import com.projetmeteo.meteo.ClasseMeteo.WeatherDataCurrentConditions;
import com.projetmeteo.meteo.ClasseMeteo.WeatherDataDay;
import com.projetmeteo.meteo.ClasseMeteo.WeatherDataHour;
import com.projetmeteo.meteo.ClasseMeteoJSON.WeatherCity;
import com.projetmeteo.meteo.ClasseMeteoJSON.WeatherDay;
import com.projetmeteo.meteo.ClasseMeteoJSON.WeatherHour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

// Indique que cette classe est un service Spring
@Service
public class WeatherService {
    @Autowired
    private WeatherDataRepository weatherRepository; // Injecte le dépôt pour les opérations de base de données
    
    @Value("${weather.api.key}")
    private String apiKey;
    
    // Sauvegarde les données météorologiques dans la base de données
    public void saveWeatherData(WeatherDataCity WeatherDataCity) {
        weatherRepository.save(WeatherDataCity); // Clé API pour les requêtes météo
    }

    // Télécharge et sauvegarde les données météorologiques sur 7 jours pour une ville
    public void saveDownloadDay(String city){
        try {
            int i = 1; // Compteur pour itérer sur les jours
            ObjectMapper objectMapper = new ObjectMapper(); // Mapper pour convertir JSON en objets Java
            // Effectue une requête API pour obtenir les données météo
            WeatherCity weatherDataResponse = objectMapper.readValue(new URL("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" + city + "/next7days?unitGroup=metric&key=" + apiKey + "&elements=datetime,temp,tempmax,tempmin,humidity,precipprob,windspeed,sunrise,sunset,conditions,description,icon&lang=fr&contentType=json"), WeatherCity.class);
            
            // Création d'objets pour stocker les conditions actuelles et les jours
            WeatherDataCurrentConditions wdCurrentCondition = new WeatherDataCurrentConditions(weatherDataResponse.getCurrentConditions().getDatetime(), weatherDataResponse.getCurrentConditions().getTemp(), weatherDataResponse.getCurrentConditions().getHumidity(), weatherDataResponse.getCurrentConditions().getPrecipProb(), weatherDataResponse.getCurrentConditions().getWindSpeed(), weatherDataResponse.getCurrentConditions().getSunrise(), weatherDataResponse.getCurrentConditions().getSunset(), weatherDataResponse.getCurrentConditions().getConditions(), weatherDataResponse.getCurrentConditions().getIcon());
            WeatherDataCity wdc = new WeatherDataCity(null, weatherDataResponse.getLatitude(), weatherDataResponse.getLongitude(), weatherDataResponse.getResolvedAddress(), weatherDataResponse.getAddress(), weatherDataResponse.getTimezone(), weatherDataResponse.getTzoffset(), wdCurrentCondition);
            List<WeatherDataDay> lday = new ArrayList<WeatherDataDay>();
            List<WeatherDataHour> lhour = new ArrayList<WeatherDataHour>();

            // Boucle sur chaque jour de la réponse météo
            for (WeatherDay day : weatherDataResponse.getDays()) {
               lday.add(new WeatherDataDay(null, day.getDatetime(), day.getTemp(), day.getTempMax(), day.getTempMin(), day.getHumidity(), day.getPrecipProb(), day.getWindSpeed(), day.getSunrise(), day.getSunset(), day.getConditions(), day.getDescription(), day.getIcon()));
               wdc.setWeatherDay(lday);
                if(i == 1){
                     // Si c'est le premier jour, ajoute les données horaires
                    for (WeatherHour hour : day.getHours()) {
                        lhour.add(new WeatherDataHour(hour.getDatetime(), hour.getTemp(), hour.getHumidity(), hour.getPrecipProb(), hour.getWindSpeed(), hour.getConditions(), hour.getIcon())); 
                    }
                    wdc.getWeatherDay().get(0).setWeatherHour(lhour); // Assigne les heures au premier jour
                    //weatherDataResponse.getDays().get(0); 
                }   
                i++;
            }
            weatherRepository.save(wdc); // Sauvegarde les données dans la base de données
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
