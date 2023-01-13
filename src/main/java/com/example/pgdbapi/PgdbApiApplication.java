package com.example.pgdbapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class PgdbApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PgdbApiApplication.class, args);
	}

}
