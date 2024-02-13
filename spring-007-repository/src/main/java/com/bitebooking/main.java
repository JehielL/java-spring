package com.bitebooking;

import com.bitebooking.model.Book;
import com.bitebooking.model.Status;
import com.bitebooking.repository.BookRepository;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class main {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(main.class, args);
		BookRepository repo = context.getBean(BookRepository.class);

		Book book1 = new Book(null, "book1", 100,100.0,true, Status.DRAFT, LocalDate.of(2024, 2, 2));
		Book book2 = new Book(null, "book2", 200,200.0,false, Status.CENSORED, LocalDate.of(2024, 2, 2));
		Book book3 = new Book(null, "book3", 300,300.0,false, Status.DISCONTINUED, LocalDate.of(2024, 2, 2));
		Book book4 = new Book(null, "book4", 400,400.0,true, Status.DRAFT, LocalDate.of(2024, 2, 2));
		Book book5 = new Book(null, "book5", 500,500.0,false, Status.PUBLISHED, LocalDate.of(2024, 2, 2));
		Book book6 = new Book(null, "book6", 600,600.0,false, Status.PUBLISHED, LocalDate.of(2024, 2, 2));
		Book book7 = new Book(null, "book7", 700,700.0,true, Status.DRAFT, LocalDate.of(2024, 2, 2));
		Book book8 = new Book(null, "book8", 800,800.0,false, Status.CENSORED, LocalDate.of(2024, 2, 2));
		Book book9 = new Book(null, "book9", 900,900.0,true, Status.DISCONTINUED, LocalDate.of(2024, 2, 2));
		Book book10 = new Book(null, "book10", 1000,1100.0,true, Status.DRAFT, LocalDate.of(2024, 2, 2));

		List<Book> books = List.of(book1, book2, book3, book4, book5, book6,book7,book8,book9,book10);
		repo.saveAll(books);

		List<Book> booksToSave = new ArrayList<>();

		for(int i =0; i < 20; i++){

			int numPages = 200+i;
			double price = 100 +i;
			Book another = new Book(null, "book" +i, numPages, price, true, Status.DRAFT,LocalDate.now());
			booksToSave.add(another);
			repo.saveAll(booksToSave);


			//for (Book book: repo.findByNumPagesLessThan(110))System.out.println(book);

			for (Book book: repo.findByAvailableTrue()) System.out.println(book);

		}
	}
}
