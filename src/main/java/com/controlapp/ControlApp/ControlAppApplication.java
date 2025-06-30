package com.controlapp.ControlApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class ControlAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(ControlAppApplication.class, args);
	}
}


