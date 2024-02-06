package com.example.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(unique = true, length = 13)
    private String isbn;

    @Column(name = "num_pages")
    private Integer numPages;

    private Double price;

    @ManyToOne
    private Author author;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", numPages=" + numPages +
                ", price=" + price +
                '}';
    }
}
