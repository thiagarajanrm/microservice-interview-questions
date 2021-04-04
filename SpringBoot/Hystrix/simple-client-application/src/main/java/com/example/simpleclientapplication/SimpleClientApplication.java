package com.example.simpleclientapplication;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@SpringBootApplication
@EnableCircuitBreaker
//@EnableHystrix
//@EnableHysrixDashBoard  - deprecated
//@DefaultProperties(defaultFallback = "defaultProductList")
public class SimpleClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleClientApplication.class, args);
	}

	@GetMapping
	@HystrixCommand(fallbackMethod = "defaultProductList")
	// @HystrixCommand(fallbackMethod = "defaultProductList", commandProperties = {
	// @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliSeconds",
	// value = "500") })
	// @HystrixCommand
	public List<String> cloudProductList() {
		RestTemplate restTemplate = new RestTemplate();
		URI uri = URI.create("http://localhost:8090/products");
		return restTemplate.getForObject(uri, List.class);
	}

	public List<String> defaultProductList() {
		return Arrays.asList("spring cloud product from fallback method");
	}
}
