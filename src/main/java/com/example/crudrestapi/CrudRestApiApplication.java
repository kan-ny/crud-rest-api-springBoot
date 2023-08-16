package com.example.crudrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudRestApiApplication {

	public static void main(String[] args) {

		System.out.println("CRUD-REST API Started..");
		SpringApplication.run(CrudRestApiApplication.class, args);
	}

}
