package com.shop.securedcustomerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.shop.securedcustomerservice")
@SpringBootApplication
@EntityScan(basePackages = {"com.shop.securedcustomerservice.domain"})
public class SecuredCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuredCustomerServiceApplication.class, args);
	}
}

