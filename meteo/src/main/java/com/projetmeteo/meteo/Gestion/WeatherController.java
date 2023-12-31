package com.projetmeteo.meteo.Gestion;

import java.time.LocalTime;
import java.util.List;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.projetmeteo.meteo.ClasseMeteo.WeatherDataCity;
import com.projetmeteo.meteo.ClasseMeteo.WeatherDataDay;
import com.projetmeteo.meteo.ClasseMeteo.WeatherDataHour;

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
         submitWeatherData("Paris", model);
        submitWeatherData("Lyon", model);
        submitWeatherData("Lille", model);
        submitWeatherData("Marseille", model);
        submitWeatherData("Rennes", model);
        submitWeatherData("Bordeaux", model);
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
    public String submitWeatherData(@RequestParam String city, Model model) {
        city = city.toLowerCase();
        try {
            List<WeatherDataCity> weatherDataList = repo.findAllByaddress(city);
            if (Iterables.isEmpty(weatherDataList)) {
                weatherService.saveDownloadDay(city);
            }  
            weatherDataList = repo.findAllByaddress(city);
            model.addAttribute("weatherDataLists", weatherDataList);
            // Récupérer la première journée de météo
            WeatherDataDay firstWeatherDay = weatherDataList.get(0).getWeatherDay().get(0);

            // Récupérer les heures de la première journée
            List<WeatherDataHour> weatherHours = firstWeatherDay.getWeatherHour();

            // Diviser les heures en groupes de 3
            List<List<WeatherDataHour>> groupedWeatherHours = Lists.partition(weatherHours, 3);
                // System.out.println(groupedWeatherHours);
            // Ajouter la liste groupée au modèle
            model.addAttribute("groupedWeatherHours", groupedWeatherHours);

                // Obtenez l'heure actuelle
            LocalTime currentTime = LocalTime.now();

            // Calculez l'index de la slide correspondant à l'heure actuelle (par exemple, division par 3)
            int activeSlideIndex = currentTime.getHour() / 3;

            model.addAttribute("activeSlideIndex", activeSlideIndex);
    
            return "fragments/weatherDataFragment";
        } catch (Exception e) {
            return "redirect::/error";
        }
    }

    @PostMapping("/manageDays")
    public String manageDays(Model model) {
        try {
            List<WeatherDataCity> weatherDataList = repo.findAll();
            model.addAttribute("weatherDataLists", weatherDataList);
            model.addAttribute("city", null);
            return "fragments/manageFragment";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @PostMapping("/error")
    public String manageError(String city, Model model) {
        model.addAttribute("weatherDataLists", "Une erreur est survenu.");  
        return "index";
    }

}