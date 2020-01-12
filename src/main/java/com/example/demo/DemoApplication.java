package com.example.demo;

import java.sql.Connection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.EmployeeDaoImpl;
import com.example.demo.util.Connector;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Connection getConnection() {
		Connector connector = new Connector();
		return connector.getConnection();
	}
}
