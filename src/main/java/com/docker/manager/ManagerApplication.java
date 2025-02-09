package com.docker.manager;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ManagerApplication {

	private static final Logger logger = LoggerFactory.getLogger(ManagerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ManagerApplication.class, args);
	}

	@PostConstruct
	public void printDocumentationLinks() {
		logger.info("==================================================");
		logger.info("API Documentation available at:");
		logger.info("Swagger UI: http://localhost:8080/docs.html");
		logger.info("Swagger JSON: http://localhost:8080/api-docs");
		logger.info("==================================================");
	}
}
