package com.example.restaurantsmodels;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

public class Dish {

    private Long id;

    private String title;

    private String description;

    private Double price;

    private Boolean glutenFree;
    // si es vegano
    // si es frio o caliente
    // si es salado
    @ManyToOne
    Restaurant restaurant;
    @ManyToMany
    private List<Dish> dishes = new ArrayList<>();

    private Double totalPrice;
}
