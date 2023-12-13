package com.projetmeteo.meteo;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	@Autowired
	WeatherDataRepository repo;

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="à tous") String name, Model model) {
			WeatherData wD = new WeatherData();
		wD.setDatetime(new Date());
		wD.setTemp(12);
		wD.setTempmax(12);
		wD.setTempmin(12);
		wD.setHumidity(12);
		wD.setPrecipprob(12);
		wD.setWindspeed(12);
		wD.setSunrise(new Date());
		wD.setSunset(new Date());
		wD.setConditions("OK");
		wD.setDescription("OK");

		repo.save(wD);
		
        model.addAttribute("greeting", repo.findById(1L).get().getDatetime().toString());

        return "greeting";
	}

	@GetMapping("/weather")
	public String greeting(Model model) {
		Optional<WeatherData> wd = repo.findById(1L);
		
        model.addAttribute("greeting", wd.get().getConditions());

        return "greeting";
	}

}