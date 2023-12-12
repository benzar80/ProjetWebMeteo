package com.projetmeteo.meteo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	@Autowired
	WeatherDataRepository repository;

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="à tous") String name, Model model) {
		//repository.
		model.addAttribute("name", name);
		return "greeting";
	}

}