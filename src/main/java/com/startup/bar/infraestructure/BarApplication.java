package com.startup.bar.infraestructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.startup.bar.crosscutting",
		"com.startup.bar.infraestructure",
		"com.startup.bar.modules"
})
@EntityScan(basePackages = "com.startup.bar.crosscutting.persistence.entity")
@EnableMongoRepositories("com.startup.bar.crosscutting.persistence.repository")
public class BarApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarApplication.class, args);
	}

}
