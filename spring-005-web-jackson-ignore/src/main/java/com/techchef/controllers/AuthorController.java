package com.techchef.controllers;


import com.techchef.models.Author;
import com.techchef.models.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class AuthorController {

    private final Logger log = LoggerFactory.getLogger(AuthorController.class);


    @GetMapping("/author")
    public Author findAuthor(){
        log.info("Peticion REST a findAuthor ");
        log.warn("Peticion WARM REST a findAuthor");
        Book book1 = new Book();
        book1.setId(1L);


        Author author = new Author();
        author.setId(1L);
        author.setName("Carmen Mola");
        author.setBiography("Lorem ipsum dolo..");

        author.getBooks().add(book1);

        book1.setAuthor(author);

        return author;


    }


}
