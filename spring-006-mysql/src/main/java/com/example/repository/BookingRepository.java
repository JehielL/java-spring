package com.example.repository;

import com.example.restaurantsmodels.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking findByDateBetween(LocalDateTime dateStart, LocalDateTime dateEnd);

    List<Booking> findByStatusEndsWith(String status);
}