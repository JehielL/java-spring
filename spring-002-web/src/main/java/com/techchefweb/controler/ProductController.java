package com.techchefweb.controler;

import com.techchefweb.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController

public class ProductController {

    //find all array list
    @GetMapping("/products")
    public List<Product> findAll() {

        //crear una lista de productos

        List<Product> products = new ArrayList<>();

        //crear 3 productos

        Product tvSamsung = new Product(1L, "Tv Samsung 52", 400.0, true, LocalDate.now());
        Product pcMsi = new Product(2L, "PC MSI modern", 600.0, false, LocalDate.now());
        Product spOnePlus = new Product(3L, "One plus 12", 900.0, false, null);

        // insertar 3 productos

        products.add(tvSamsung);
        products.add(pcMsi);
        products.add(spOnePlus);

        //devolver la lista


        return products;
    }

    @GetMapping("/products2")

    public List<Product> findAll2(){

        return List.of(
                new Product(1L, "Tv Samsung 52", 400.0, true, LocalDate.now()),
                new Product(2L, "PC MSI modern", 600.0, false, LocalDate.now()),
                new Product(3L, "One plus 12", 900.0, false, null)

        );
    }

    @GetMapping("product-demo")
    public Product findProduct(){
        return new Product(1L, "Tv Samsung 52", 400.0, true, LocalDate.now());


    }

    //find by id
    @GetMapping("products/{id}")
    public Product findProductById(@PathVariable Long id){
    return new Product(id, "Playstation5", 399.0, true, LocalDate.now());

    }

    @GetMapping("products/by-title/{title}")
    public Product findProductByTitle(@PathVariable String title){
        return new Product(1L, title, 399.0, true, LocalDate.now());

    }
    @GetMapping("products/by-price/min/{min}/max/{max}")
    public List<Product> findProductByprice(@PathVariable Double min, @PathVariable Double max){

        return List.of(
                new Product(1L, "Tv Samsung 52", 400.0, true, LocalDate.now()),
                new Product(2L, "PC MSI modern", 600.0, false, LocalDate.now()),
                new Product(3L, "One plus 12", 900.0, false, null),
                new Product(4L, "Android", 100.0, false, null)
        );
    }

    @PostMapping("products")

    public Product create(@RequestBody Product product){

        System.out.println(product);

        return product;

    }

    @PutMapping("/products/{id}")
    public Product update(@PathVariable Long id,
                          @RequestBody Product product){
        System.out.println(product.id());

        return product;

    }

    @DeleteMapping("/products/{id}")
    public void deleteById(@PathVariable Long id){

        System.out.println("Borrando producto " + id);

    }

}






