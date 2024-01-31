package com.techchef.controller;


import com.techchef.models.Product;
import com.techchef.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@AllArgsConstructor
@RestController



public class ProductController {


    //atributos
    private ProductService productService;


    //metodos
    @GetMapping("products")
    public List<Product> finAllProducts(){
        return productService.findAll();


    }
}
