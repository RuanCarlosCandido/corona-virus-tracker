package org.coronaVirusTracker.controllers;

import java.io.IOException;
import java.util.Map;

import org.coronaVirusTracker.services.CoronaVirusDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Corona Virus Tracker endPoint")
@Controller // NOT a RESTCONTROLLER(Returning a REST response converted in a JSON response)
public class HomeController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CoronaVirusDataService coronaVirusDataService;

	//Model is used to map attributes in 'Thymeleaf' framework
	@Operation(summary = "List all Locations Status")
	@GetMapping("/status")
	public String home(Model model) throws IOException {
		LOGGER.info("retrieving data via endpoint(/status) ");
		Map<String, Object> result = coronaVirusDataService.getAllStats();
		model.addAllAttributes(result);
		LOGGER.info("retrieved data: " + result.toString());

		return "home";
	}

}
