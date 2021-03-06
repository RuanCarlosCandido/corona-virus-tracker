package org.coronaVirusTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * When running this application on a local machine remember to run it in dev profile/environment (boot dashboard)
 * @author ruan.lima
 */
@EnableAdminServer
@SpringBootApplication
public class CoronaVirusTrackerApplication {  

	public static void main(String[] args) {		
		SpringApplication.run(CoronaVirusTrackerApplication.class, args);
	}

}
