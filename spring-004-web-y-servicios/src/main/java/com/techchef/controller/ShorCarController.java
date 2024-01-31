package com.techchef.controller;

import com.techchef.dto.ShopCartHasProduct;
import com.techchef.dto.ShopCartPrice;
import com.techchef.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ShorCarController {

    private ProductService productService;
    @GetMapping("/calculate-total-price")
    public Double getCurrentTotalPrice(){

        Double price = productService.calculateTotalPrice();
        return price;


    }

    @GetMapping("calculate-total-price2")
    public ShopCartPrice getCurrentTotalPrice3(){
        Double price = productService.calculateTotalPrice();
        return new ShopCartPrice(price);



    }

    @GetMapping("shop-cart-available")
    public ShopCartHasProduct checkIfShopCartHasProducts(){
        Boolean exist = productService.checkIfShopCartHasProducts();
    return new ShopCartHasProduct(exist);
    }


}
