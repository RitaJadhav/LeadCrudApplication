package com.crud.lead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan ({"com.crud.lead.*", "com.crud.lead.service"})
public class LeadSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeadSpringBootApplication.class, args);
	}

}
