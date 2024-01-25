package com.techchefweb.controler;

import com.techchefweb.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @GetMapping("/cliente")

    public String devolverCliente(){
        return "Cliente 1";


    }

    @GetMapping("/objeto-cliente")

    public Customer devolverObjeto(){
        return new Customer("1112233","Mike",30, true);
    }


}
