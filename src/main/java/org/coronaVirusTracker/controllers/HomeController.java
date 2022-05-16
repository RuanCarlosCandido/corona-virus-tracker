package org.coronaVirusTracker.controllers;

import java.io.IOException;

import org.coronaVirusTracker.services.CoronaVirusDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //NOT a RESTCONTROLLER(Returning a REST response converted in a JSON response)
public class HomeController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CoronaVirusDataService coronaVirusDataService;
	
	@GetMapping("/")
	public String home(Model model) throws IOException {
		LOGGER.info("retrieved data: " + coronaVirusDataService.getAllStats().toString());
		model.addAttribute("locationStats",coronaVirusDataService.getAllStats());
		return "home";
	}
	
}
