package com.example.pathologieapp;

import com.example.pathologieapp.configuration.Configurations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableConfigurationProperties(Configurations.class)
public class PathologieAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PathologieAppApplication.class, args);
	}
}