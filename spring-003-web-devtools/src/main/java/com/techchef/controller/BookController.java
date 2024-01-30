package com.techchef.controller;
import com.techchef.model.Author;
import com.techchef.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    //declarar array list de books
    List<Book> books;

    //constructor
    public BookController() {
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
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(this.books);
    }

    @GetMapping("books/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        for (Book book : this.books) {

            if (book.id().equals(id)) {

                return ResponseEntity.ok(book);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("books/by-author-id/{authorId}")
    public ResponseEntity<List<Book>> findAllByAuthorId(@PathVariable Long authorId) {

        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : this.books) {
            if (book.author().id().equals(authorId)) {
                filteredBooks.add(book);
            }

        }

        if (filteredBooks.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(filteredBooks);

    }

    @PostMapping("books")
    public ResponseEntity<Book> create(@RequestBody Book book) {

        if (book.id() != null)
            return ResponseEntity.badRequest().build();

        this.books.add(book);

        return ResponseEntity.status(200).body(book);

    }

    @PutMapping("books/{id}")
    public ResponseEntity<Book> update(@RequestBody Book book, @PathVariable Long id) {

        if (id == null || book.id() == null)
            return ResponseEntity.badRequest().build();
        // opcion 1
        int index = -1;
        for (Book bookFromList : this.books) {
            if (bookFromList.id().equals(id)) {
                index = this.books.indexOf(bookFromList);
            }
        }

        for (int i = 0; i < this.books.size(); i++) {
            if (this.books.get(i).id().equals(id)) {
                index = i;
            }


        }
        //Comprobar si se ha encontrado el libro

        if (index == -1)
            return ResponseEntity.notFound().build();

        //

        this.books.set(index, book);
        return ResponseEntity.ok(book);




    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){

        int index = -1;
        for(Book bookFromList: this.books){
            if (bookFromList.id().equals(id)){
                index = this.books.indexOf(bookFromList);

            }
        }

        if(index == -1)
            return ResponseEntity.badRequest().build();


        this.books.remove(index);


        return ResponseEntity.noContent().build();



    }

    @DeleteMapping("books")
    public ResponseEntity<Void> deleteAll(){

        this.books.clear();

        return ResponseEntity.noContent().build();


    }


}
