package com.certidevs.controller;

import com.certidevs.model.Author;
import com.certidevs.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    //declarar array list de books
   List<Book> books;

    //constructor
    public BookController(){
        books = new ArrayList<>();
        books.add(
                new Book(1L,
                        "La novia gitana",
                        10.50,
                        true,
                        new Author(1L, "Carmen mola", "Madrid"))
                );
        books.add(
                new Book(2L,
                        "Es Peligroso asomarse al exterior",
                        11.50,
                        true,
                        new Author(2L, "Poncela", "Madrid"))
        );
        books.add(
                new Book(3L,
                        "La novia gitana",
                        10.50,
                        true,
                        new Author(1L, "Carmen mola", "Madrid"))
        );

    }

    @GetMapping("books")
    public ResponseEntity<List<Book>> findAll(){
        return ResponseEntity.ok(this.books);
    }

    @GetMapping("books/{id}")
    public List<Book> findById(@PathVariable Long id){
        return books;
    }



}
