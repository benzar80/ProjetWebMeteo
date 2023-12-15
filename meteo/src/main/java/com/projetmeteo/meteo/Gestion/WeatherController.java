package com.projetmeteo.meteo.Gestion;

import com.projetmeteo.meteo.ClasseMeteo.WeatherDataCity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {
	@Autowired
	WeatherDataRepository repo;

	@Autowired
    private WeatherService weatherService;

	@PostMapping("/test")
    public String submitWeatherData(@RequestParam("city") String city, Model model){
        weatherService.saveDownloadDay(city);
        Iterable<WeatherDataCity> weatherDataList = repo.findAllByaddress(city);
        model.addAttribute("weatherDataLists", weatherDataList);  // Correction ici
        return "index";
    }
}