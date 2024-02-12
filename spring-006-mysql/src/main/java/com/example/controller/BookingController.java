package com.example.controller;

import com.example.repository.BookingRepository;
import com.example.repository.FilmRepository;
import com.example.restaurantsmodels.Booking;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookingController {

    private final BookingRepository bookingRepository;
    private final FilmRepository filmRepository;

    @GetMapping("booking")
    public List<Booking> findAll(){

        return bookingRepository.findAll();
    }

    @PostMapping("booking")
    public Booking create(@RequestBody Booking booking){

        return bookingRepository.save(booking);
    }

    @PutMapping("booking{id}")
    public Booking update(@RequestBody Booking booking,
                          @PathVariable Long id){
        return bookingRepository.save(booking);
    }

    @DeleteMapping("booking{id}")
    public void delete(@PathVariable Long id){

        bookingRepository.deleteById(id);

    }
}
