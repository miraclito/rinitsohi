package com.example.enviodetareasservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EnviodetareasServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnviodetareasServiceApplication.class, args);
	}

}
