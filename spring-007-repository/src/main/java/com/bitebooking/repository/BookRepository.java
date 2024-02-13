package com.bitebooking.repository;

import com.bitebooking.model.Book;
import com.bitebooking.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByNumPagesBetween(Integer numPagesStart, Integer numPagesEnd);

    List<Book> findByNumPagesLessThan(Integer numPages);

    List<Book> findByTitleContains(String title);

    List<Book> findByAvailableTrue();

    List<Book> findByStatus(Status status);

    List<Book> findByNumPagesGreaterThan(Integer numPages);


}