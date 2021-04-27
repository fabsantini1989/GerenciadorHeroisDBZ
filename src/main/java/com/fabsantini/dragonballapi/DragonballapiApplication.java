package com.fabsantini.dragonballapi;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class DragonballapiApplication {

	public static void main(String[] args) {
		//Roda a aplicação spring;
		SpringApplication.run(DragonballapiApplication.class, args);
		System.out.println("RODANDO APLICAÇÃO DE DRAGONBALL COM O WEBFLUX!");

	}
}
