package com.projetmeteo.meteo.Gestion;

import java.time.LocalTime;

import com.google.common.collect.Iterables;
import com.projetmeteo.meteo.ClasseMeteo.WeatherDataCity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.annotation.PostConstruct;

@Controller
public class WeatherController {
	@Autowired
	WeatherDataRepository repo;

	@Autowired
    private WeatherService weatherService;

    @PostConstruct
    public void init() {
        Model model = new ExtendedModelMap();
        String initialCity;
        initialCity = "Paris";
        submitWeatherData(initialCity, model);
        initialCity = "Lyon";  
        submitWeatherData(initialCity, model);
        initialCity = "Lille";  
        submitWeatherData(initialCity, model);
        initialCity = "Marseille";  
        submitWeatherData(initialCity, model);
        initialCity = "Rennes";  
        submitWeatherData(initialCity, model);
        initialCity = "Bordeaux";  
        submitWeatherData(initialCity, model);

        LocalTime currentTime = LocalTime.now();
        System.out.println("Heure actuelle : " + currentTime);
    }

    @Scheduled(cron = "0 0 5 * * *", zone = "Europe/Paris")
    public void updateWeatherData() {
        repo.deleteAll();
        Model model = new ExtendedModelMap();
        String initialCity;
        initialCity = "Paris";
        submitWeatherData(initialCity, model);
        initialCity = "Lyon";  
        submitWeatherData(initialCity, model);
        initialCity = "Lille";  
        submitWeatherData(initialCity, model);
        initialCity = "Marseille";  
        submitWeatherData(initialCity, model);
        initialCity = "Rennes";  
        submitWeatherData(initialCity, model);
        initialCity = "Bordeaux";  
        submitWeatherData(initialCity, model);
    }

	@PostMapping("/test")
    public String submitWeatherData(@RequestParam("city") String city, Model model){
        city = city.toLowerCase();
        Iterable<WeatherDataCity> weatherDataList = repo.findAllByaddress(city);
        if(Iterables.isEmpty(weatherDataList)){
            weatherService.saveDownloadDay(city);
            weatherDataList = repo.findAllByaddress(city);
            model.addAttribute("weatherDataLists", weatherDataList); 
        }
        else{
            weatherDataList = repo.findAllByaddress(city);
            model.addAttribute("weatherDataLists", weatherDataList); 
        }
        return "index";
    }

    @PostMapping("/error")
    public String manageError(String city, Model model) {
        model.addAttribute("weatherDataLists", "Une erreur est survenu.");  
        return "index";
    }

}