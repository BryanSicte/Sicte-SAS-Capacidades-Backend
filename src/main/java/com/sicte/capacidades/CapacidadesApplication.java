package com.sicte.capacidades;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CapacidadesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapacidadesApplication.class, args);
	}

}
