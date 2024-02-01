package com.techchef.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Long id;
    private String title;
    private Double price;
    private Integer numPages;
    private Boolean available;
    private Author author;

}
