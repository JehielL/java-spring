package com.techchef.service;

import com.techchef.models.Product;
import com.techchef.models.ProductType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {

    private List<Product> products;
    private UserService userService;


    public ProductService(UserService userService) {
        this.userService = userService;
        this.userService.findById(1L);
        System.out.println("User service inyectado correctamente en productService");
        products = new ArrayList<>();
        products.add(Product.builder()
                .id(1L)
                .price(200.0)
                .title("TV")
                .type(ProductType.SMART_TV)
                .isAvailable(true)
                .build());

        Product product2 = new Product(2L, "Apple Watch", 450.00, ProductType.SMART_WATCH, true);
        products.add(product2);

        Product product3 = new Product();
        product3.setId(3L);
        product3.setTitle("Lg Ultra Wide");
        product3.setPrice(1000.00);
        product3.setType(ProductType.SMART_TV);
        product3.setIsAvailable(true);
        products.add(product3);
        System.out.println(product3);

    }

    public List<Product> findAll(){

        return new ArrayList<>(products); // crea una copia del array list

    }

    public Double calculateTotalPrice(){

        return 100.0;
    }

    public Boolean checkIfShopCartHasProducts(){
        return !this.products.isEmpty();
    }
}
