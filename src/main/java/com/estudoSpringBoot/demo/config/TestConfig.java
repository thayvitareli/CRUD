package com.estudoSpringBoot.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudoSpringBoot.demo.entities.Product;
import com.estudoSpringBoot.demo.repositories.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	ProductRepository productRepository;
		
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
	
		Product p1 = new Product(1L,"Mackbook Pro", 4000.00, "Tech");
		Product p2 = new Product(2L,"Pc Gamer", 5000.00, "Tech");
		Product p3 = new Product(3L,"Pet House", 300.00, "Pet");
			
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
	}

	
}
