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

@RestController // Indique que cette classe est un contrôleur REST
public class WeatherControllerRest {
    @Autowired
    WeatherDataRepository repo;

    // Méthode pour mettre à jour les données météo actuelles
    @PostMapping("/updateWeatherData")
    public void sendWeatherData(
            @RequestParam Long id, // ID de l'entité météo
            @RequestParam String column, // Colonne à mettre à jour
            @RequestParam String value, // Nouvelle valeur pour la colonne
            Model model) {
        try {

            WeatherDataCity weatherData = repo.findById(id).get(); // Obtient les données météo de la ville par ID
            WeatherDataCurrentConditions weatherDataCurrent = weatherData.weatherDataCurrentConditions(); // Obtient les
                                                                                                          // conditions
                                                                                                          // actuelles

            // Met à jour la valeur en fonction de la colonne spécifiée
            switch (column) {
                case "temp":
                    weatherDataCurrent.setTemp(Double.parseDouble(value));
                    break;
                case "humidity":
                    weatherDataCurrent.setHumidity(Double.parseDouble(value));
                    break;
                case "precipprob":
                    weatherDataCurrent.setPrecipprob(Double.parseDouble(value));
                    break;
                case "windspeed":
                    weatherDataCurrent.setWindspeed(Double.parseDouble(value));
                case "sunrise":
                    weatherDataCurrent.setSunrise((String) value);
                case "sunset":
                    weatherDataCurrent.setSunset((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid column name: " + column);
            }

            repo.save(weatherData); // Sauvegarde les modifications

            System.out.println("Données mise à jour avec succès !");
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    // Méthode similaire pour mettre à jour les données d'un jour spécifique
    @PostMapping("/updateWeatherData2")
    public void sendWeatherData2(
            @RequestParam Long id, // ID de l'entité météo
            @RequestParam int idDay, // Index du jour à mettre à jour
            @RequestParam String column, // Colonne à mettre à jour
            @RequestParam String value, // Nouvelle valeur pour la colonne
            Model model) {
        try {

            WeatherDataCity weatherData = repo.findById(id).get(); // Obtient les données météo de la ville par ID
            WeatherDataDay weatherDataDayNew = weatherData.getWeatherDay().get(idDay); // Obtient les données du jour
                                                                                       // spécifique

            switch (column) {
                case "temp":
                    weatherDataDayNew.setTemp(Double.parseDouble(value));
                    break;
                case "tempmax":
                    weatherDataDayNew.setTempmax(Double.parseDouble(value));
                    break;
                case "tempmin":
                    weatherDataDayNew.setTempmin(Double.parseDouble(value));
                    break;
                case "humidity":
                    weatherDataDayNew.setHumidity(Double.parseDouble(value));
                    break;
                case "precipprob":
                    weatherDataDayNew.setPrecipprob(Double.parseDouble(value));
                    break;
                case "windspeed":
                    weatherDataDayNew.setWindspeed(Double.parseDouble(value));
                    break;
                case "sunrise":
                    weatherDataDayNew.setSunrise((String) value);
                    break;
                case "sunset":
                    weatherDataDayNew.setSunset((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid column name: " + column);
            }
            repo.save(weatherData); // Sauvegarde les modifications
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
