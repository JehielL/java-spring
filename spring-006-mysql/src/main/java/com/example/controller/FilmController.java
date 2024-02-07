package com.example.controller;

import com.example.models.Film;
import com.example.repository.FilmRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
public class FilmController {

    private final FilmRepository filmRepository;
    @GetMapping("films")
    public List<Film> findAll(){
        return filmRepository.findAll();

    }

    @PostMapping("films")
    public Film create(@RequestBody Film film){
        return filmRepository.save(film);

    }

    @PutMapping("films/{id}")
    public Film update(@RequestBody Film film,
                       @PathVariable Long id){
        return filmRepository.save(film);
    }

}
