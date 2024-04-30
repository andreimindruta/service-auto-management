package com.servicecompany.serviceautomanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceAutoManagementApplication {

	public static final Logger log = LoggerFactory.getLogger(ServiceAutoManagementApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ServiceAutoManagementApplication.class, args);
		log.info("Application started successfully");
	}

}

