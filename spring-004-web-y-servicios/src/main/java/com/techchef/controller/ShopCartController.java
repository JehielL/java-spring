package com.techchef.controller;

import com.techchef.dto.ShopCartHasProduct;
import com.techchef.dto.ShopCartPrice;
import com.techchef.models.User;
import com.techchef.service.ProductService;
import com.techchef.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ShopCartController {

    private ProductService productService;
    private UserService userService;


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

    @GetMapping("shopcart-user/{id}")
    public User findUserById(@PathVariable Long id){
        return  userService.findById(id);
    }


}
