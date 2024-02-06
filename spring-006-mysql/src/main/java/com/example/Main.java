package com.example;

import com.example.models.Author;
import com.example.repository.AuthorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Main.class, args);

		AuthorRepository repo = context.getBean(AuthorRepository.class);

		Author a1 = new Author(null, "a1", "a1@gmail.com", 10000.0, true, LocalDate.now());
		Author a2 = new Author(null, "a2", "a2@gmail.com", 15000.00, false, LocalDate.now());
		Author a3 = new Author(null, "a2", "a3@gmail.com", 15000.00, false, LocalDate.now());
		repo.save(a1);
		repo.save(a2);
		repo.save(a3);

		//CRUD : RETRIEVE con findAll
		List<Author> authors = repo.findAll();
		System.out.println(authors);

		// CRUD : RETRIEVE un solo autor por su clave primaria

		Optional<Author> authorOptional = repo.findById(99L);
		if (authorOptional.isPresent()){
			Author author = authorOptional.get();
			System.out.println(author);

		} else {
			System.out.println("No se ha encontrado el author");
		}

		//Author author1 = authorOptional.orElseThrow();

		//CRUD: DELETE con deletebyId

		// repo.deleteById(1L);

	}



}
