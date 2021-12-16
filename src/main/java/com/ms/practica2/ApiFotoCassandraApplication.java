package com.ms.practica2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class ApiFotoCassandraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiFotoCassandraApplication.class, args);
	}

}
