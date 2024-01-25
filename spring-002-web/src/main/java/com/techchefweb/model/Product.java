package com.techchefweb.model;


import java.time.LocalDate;

public record Product(Long id,
                      String title,
                      Double price,
                      Boolean avalible,
                      LocalDate creationDate) {


    public Product(Long id, String title, Double price, Boolean avalible, LocalDate creationDate) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.avalible = avalible;
        this.creationDate = creationDate;
    }
}
