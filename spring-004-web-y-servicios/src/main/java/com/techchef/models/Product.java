package com.techchef.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Product {

    private Long id;
    private String title;
    private Double price;
    private ProductType type;
    private Boolean isAvailable;


}
