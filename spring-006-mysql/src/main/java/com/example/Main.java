package com.example;

import com.example.models.*;
import com.example.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Main.class, args);

		AuthorRepository repo = context.getBean(AuthorRepository.class);
		CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
		AddressRepository addressRepository = context.getBean(AddressRepository.class);
		UserRepository userRepository = context.getBean(UserRepository.class);
		FilmRepository filmRepository = context.getBean(FilmRepository.class);
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

		Category accion = new Category(null, "Accion", 16);
		Category drama = new Category(null, "Drama", 16);
		Category infantil = new Category(null, "infantil", 12);

		categoryRepository.save(accion);

		//guardar varios objetos a la vez

		categoryRepository.saveAll(List.of(accion, drama, infantil));

		Film film1 = new Film();
		film1.setTitle("Pelicula 1");
		film1.setDurationInMin(150);
		film1.setReleaseDate(LocalDate.now());
		film1.getCategories().add(accion);
		film1.getCategories().add(drama);
		filmRepository.save(film1);

		Film film2 = new Film();
		film1.setTitle("Pelicula 2");
		film1.setDurationInMin(160);
		film1.setReleaseDate(LocalDate.now());
		film1.getCategories().add(infantil);
		film1.getCategories().add(drama);
		filmRepository.save(film2);

		Address ad1 = new Address(null, "Calle falsa", "Madrid");
		Address ad2 = new Address(null, "Calle prueba", "Madrid");
		Address ad3 = new Address(null, "Calle verdadera", "Madrid");
		addressRepository.saveAll(List.of(ad1,ad2,ad3));


		User user1 = new User(null, "u3@gmail.com", "admin", ad1);
		User user2 = new User(null, "u3@gmail.com", "admin", ad2);
		User user3 = new User(null, "u3@gmail.com", "admin", ad3);
		userRepository.saveAll(List.of(user1,user2,user3));


	}

}
