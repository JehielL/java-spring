package com.example.controller;



import com.example.models.Author;
import com.example.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class AuthorController {

    private final AuthorRepository repo;

    @GetMapping("authors")
    public List<Author>findAll(){

        return repo.findAll();
    }

    @GetMapping("authors/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id){
        Optional<Author> authorOpt = repo.findById(id);
        if(authorOpt.isPresent())
            return ResponseEntity.ok(authorOpt.get());

        else
             return ResponseEntity.notFound().build();
    }

    @PostMapping("authors")
    public ResponseEntity<Author> create(@RequestBody Author author){
        return ResponseEntity.ok(repo.save(author));

    }

    @PutMapping("authors/{id}")
    public ResponseEntity<Author> update(@PathVariable Long id,
                                         @RequestBody  Author author){

       /*
            if(!repo.existsById(id))
            return ResponseEntity.notFound().build();
           return ResponseEntity.ok(repo.save(author));
           */

        Optional<Author> authorOptional = repo.findById(id);

        if (authorOptional.isEmpty())
            return ResponseEntity.notFound().build();

        Author authorFromDB = authorOptional.get();
        authorFromDB.setActive(author.getActive());
        authorFromDB.setSalary(author.getSalary());
        return ResponseEntity.ok(repo.save(authorFromDB));
    }
}