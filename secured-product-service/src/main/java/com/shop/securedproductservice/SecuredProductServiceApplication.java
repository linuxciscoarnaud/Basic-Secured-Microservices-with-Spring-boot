package com.shop.securedproductservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.shop.securedproductservice")
@SpringBootApplication
@EntityScan(basePackages = {"com.shop.securedproductservice.domain"})
public class SecuredProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuredProductServiceApplication.class, args);
	}
}
