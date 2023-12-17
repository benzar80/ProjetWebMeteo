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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        submitWeatherData("Paris", model);
        submitWeatherData("Lyon", model);
        submitWeatherData("Lille", model);
        submitWeatherData("Marseille", model);
        submitWeatherData("Rennes", model);
        submitWeatherData("Bordeaux", model);

        LocalTime currentTime = LocalTime.now();
        System.out.println("Heure actuelle : " + currentTime);
    }

    @Scheduled(cron = "0 0 5 * * *", zone = "Europe/Paris")
    public void updateWeatherData() {
        repo.deleteAll();
        Model model = new ExtendedModelMap();
        submitWeatherData("Paris", model);
        submitWeatherData("Lyon", model);
        submitWeatherData("Lille", model);
        submitWeatherData("Marseille", model);
        submitWeatherData("Rennes", model);
        submitWeatherData("Bordeaux", model);
    }

	@PostMapping("/test")
    @ResponseBody
    public String submitWeatherData(@RequestBody String city, Model model){
        city = city.toLowerCase();
        try {
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
        } catch (Exception e) {
            return "redirect:/error";
        }
        return "index";
    }

    @PostMapping("/error")
    public String manageError(String city, Model model) {
        model.addAttribute("weatherDataLists", "Une erreur est survenu.");  
        return "index";
    }

}