package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.example.demo.dbAll")
@ComponentScan(basePackages = {"com.example.demo"})
public class ToDoListApplication {


	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
		System.out.println("Spring-boot init up tudo certo (x)");

	}
}
