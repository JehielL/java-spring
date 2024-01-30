package com.techchef;

import com.techchef.models.Product;
import com.techchef.models.ProductType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		Product pcMsi = new Product();
		Product onePlus = new Product(1L, "Xsus MaX", 200.00, ProductType.SMART_PHONE, true);
	}


	Product garmin = Product.builder()
			.id(2L)
			.price(300.0)
			.isAvailable(true)
			.title("Reloj Garmin")
			.type(ProductType.SMART_PHONE)
			.build();
}
