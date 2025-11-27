package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.studyeasy.cars.Corolla;
import org.studyeasy.cars.Swift;
import org.studyeasy.AppConfig;
import org.studyeasy.interfaces.Car;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WithComponentBasedApplication {

	public static void main(String[] args) {
//		SpringApplication.run(WithComponentBasedApplication.class, args);
		//Car swift = new Swift();
				//Car corolla = new Corolla();
				
				//System.out.println(swift.specs());
				//System.out.println(corolla.specs());
				
		        
				//Car myCar = new Swift();
				//System.out.println(myCar.specs());
				
				AnnotationConfigApplicationContext context = 
					new	AnnotationConfigApplicationContext(AppConfig.class);
				
				Car myCar = context.getBean("audi",Car.class);
//				Car myCar = context.getBean(Audi.class);
				System.out.println(myCar.specs());
				context.close();

	}

}
