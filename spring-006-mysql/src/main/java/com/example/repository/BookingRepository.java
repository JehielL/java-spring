package com.example.repository;

import com.example.restaurantsmodels.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    Booking findByDateBetween(LocalDateTime dateStart, LocalDateTime dateEnd);
    List<Booking> findByStatusEndsWith(String status);
    Booking findByTitleIgnoreCase(String title);

    Optional<Booking> getByTitleIgnoreCase(String title);

}