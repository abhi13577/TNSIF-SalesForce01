package com.example.demo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IocApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(IocApplication.class, args);
		Customers c = context.getBean(Customers.class);
		c.display();
	}

}
