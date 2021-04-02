package com.example.eurekaclient2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Eurekaclient2Application {
	
	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Eurekaclient2Application.class, args);
	}

	@RequestMapping(value = "/")
	public String home() {
		
		//Harcoded URL
		//final String uri = "http://localhost:8081/";
		//Eureka URL
		final String uri = "http://EUREKACLIENT1/";
	 
	    String result = restTemplate.getForObject(uri, String.class);
	    System.out.println(result);
		
		return "Eureka Client2 - From Client1:"+result;
	}
}
