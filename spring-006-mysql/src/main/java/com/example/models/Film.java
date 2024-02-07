package com.example.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
Clase para representar una Pelicula / Film
 */
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
// JPA
@Entity // Obligatorio
@Table(name = "films") // Opcional
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer durationInMin;

    private LocalDate releaseDate;

    @ManyToMany
    @ToString.Exclude
    private List<Category> categories = new ArrayList<>();




}