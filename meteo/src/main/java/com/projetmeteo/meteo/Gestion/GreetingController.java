package com.projetmeteo.meteo.Gestion;

import com.projetmeteo.meteo.ClasseMeteo.WeatherDataDay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	@Autowired
	WeatherDataRepository repo;

	/*@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="à tous") String name, Model model) {
			WeatherData wD = new WeatherData();
		wD.setDatetime("test");
		wD.setTemp(12);
		wD.setTempmax(12);
		wD.setTempmin(12);
		wD.setHumidity(12);
		wD.setPrecipprob(12);
		wD.setWindspeed(12);
		wD.setSunrise("new Date()");
		wD.setSunset("new Date()");
		wD.setConditions("OK");
		wD.setDescription("OK");

		repo.save(wD);

		WeatherData wd2 = new WeatherData("15", 15, 15, 15, 15, 15, 15, "15", "15", "Bonjour", "Bonjour");

		repo.save(wd2);
		
        model.addAttribute("greeting", repo.findById(1L).get().getDatetime().toString());
		model.addAttribute("greeting", repo.findById(2L).get().getDatetime().toString());

        return "greeting";
	}*/

	@Autowired
    private WeatherService weatherService;

    @GetMapping("/form")
    public String showWeatherForm(Model model) {
        model.addAttribute("weatherData", new WeatherDataDay());
        return "weather-form";
    }

    @PostMapping("/submit_weather_data")
    public String submitWeatherData(WeatherDataDay weatherData) {
        weatherService.saveWeatherData(weatherData);
        return "redirect:/index";
    }

	@PostMapping("/test")
	public String submitWeatherData2(@RequestParam("city") String city, Model model){
		weatherService.saveDownload(city);
		model.addAttribute("message", repo.findAll().toString());
		return "index";
	}
}