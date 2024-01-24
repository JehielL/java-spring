package com.techchef.holamundo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring001HolamundoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Spring001HolamundoApplication.class, args);
		System.out.println("jehiel");


	}

}
