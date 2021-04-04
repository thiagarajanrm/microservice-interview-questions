package com.example.simpleproductserviceapplication;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SimpleProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleProductServiceApplication.class, args);
	}

	@GetMapping(value = "/products")
	public List<String> getAllproduct() {
		return Arrays.asList("Eureka", "Hystrix", "Zuul", "Ribbon");
	}

}
