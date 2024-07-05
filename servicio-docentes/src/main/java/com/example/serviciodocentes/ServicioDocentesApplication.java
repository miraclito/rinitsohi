package com.example.serviciodocentes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServicioDocentesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioDocentesApplication.class, args);
	}

}
