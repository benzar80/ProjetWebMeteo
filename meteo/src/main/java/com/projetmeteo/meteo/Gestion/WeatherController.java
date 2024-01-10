package com.projetmeteo.meteo.Gestion;

import java.time.LocalTime;
import java.util.List;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.projetmeteo.meteo.ClasseMeteo.WeatherDataCity;
import com.projetmeteo.meteo.ClasseMeteo.WeatherDataDay;
import com.projetmeteo.meteo.ClasseMeteo.WeatherDataHour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.annotation.PostConstruct;

@EnableScheduling
@Controller
public class WeatherController {
	@Autowired
	WeatherDataRepository repo;

	@Autowired
    private WeatherService weatherService;

    @GetMapping("/logout")
    public String handleLogout() {
        // Logique de gestion de la déconnexion
        return "/index";
    }

    @PostMapping("/login_success")
    public String loginSuccessHandler() {
      //perform audit action
      return "/admin/indexAdmin";
    }
  
    @PostMapping("/login_failure")
    public String loginFailureHandler() {
      //perform audit action
      return "/admin/login";
    }

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

    @Scheduled(fixedDelay = 1800000)
    public void updateWeatherData() {
        List<WeatherDataCity> wdL = repo.findAll();
        repo.deleteAll();
        LocalTime currentTime = LocalTime.now();
        System.out.println("MAJ à " + currentTime);
        Model model = new ExtendedModelMap();
        for (WeatherDataCity weatherDataCity : wdL) {
            submitWeatherData(weatherDataCity.getAddress(), model);
        }
        
    }
    @GetMapping("/admin")
    public String adminPage() {
        return "admin/login";
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
            return "redirect:/error";
        }
    }

    @PostMapping("/manageDays")
    public String manageDays(Model model) {
        try {
            List<WeatherDataCity> weatherDataList = repo.findAll();
            //System.out.println(weatherDataList);
            model.addAttribute("weatherDataLists", weatherDataList);
            return "fragments/manageFragment";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @DeleteMapping("/suppDataCity")
    public String suppDataCity(String city, Model model) {
        try {
            List<WeatherDataCity> weatherDataListSupp = repo.findAllByaddress(city);
            // Supprimer les données de la ville spécifiée
            repo.deleteAll(weatherDataListSupp);
            List<WeatherDataCity> updatedWeatherDataList = repo.findAll();
            model.addAttribute("weatherDataLists", updatedWeatherDataList);
    
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