package com.marcuschiu.breakerhystrix;

import org.springframework.boot.SpringApplication;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
@EnableEurekaClient
@EnableFeignClients
public class BreakerHystrixApplication {

	@Autowired
	BookService bookservice;

	public static void main(String[] args) {
		SpringApplication.run(BreakerHystrixApplication.class, args);
	}

	@GetMapping("/")
	@HystrixCommand
	public String home() {
		return bookservice.getBookServiceInstanceServiceInfo();
	}
}
