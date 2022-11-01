package com.example.orderbox2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.example.orderbox2.model.repository")
public class OrderBox2Application {

	public static void main(String[] args) {
		SpringApplication.run(OrderBox2Application.class, args);
	}

}
