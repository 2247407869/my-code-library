package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	private static final Logger log4jLogger = LogManager.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		log4jLogger.info("log4j info {}", 123);
		SpringApplication.run(DemoApplication.class, args);
	}
}
