package ru.moysklad.birdAndNest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSpringConfigured
public class BirdAndNestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BirdAndNestApplication.class, args);
	}

}
