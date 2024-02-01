package com.techchef.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private Long id;
    private String name;
    private String Biography;
    private LocalDate startCarrer;
    @JsonIgnoreProperties("author")
    private List<Book> books = new ArrayList<>();



    //asociacion



}
