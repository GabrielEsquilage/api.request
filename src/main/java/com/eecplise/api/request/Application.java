package com.eecplise.api.request;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean; // Já configurado em config/resttemplate
//import org.springframework.web.client.RestTemplate; // Já configurado em config/resttemplate

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
