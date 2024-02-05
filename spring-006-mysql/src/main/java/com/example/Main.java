package com.example;

import com.example.models.Author;
import com.example.repository.AuthorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Main.class, args);

		AuthorRepository repo = context.getBean(AuthorRepository.class);

		Author a1 = new Author(null, "a1", "a1@gmail.com", 10000.0, true, LocalDate.now());
		Author a2 = new Author(null, "a2", "a2@gmail.com", 15000.00, false, LocalDate.now());



	}

}
