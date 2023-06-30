package com.estudoSpringBoot.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudoSpringBoot.demo.entities.Product;
import com.estudoSpringBoot.demo.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll() {	
		return productRepository.findAll();
	}
	
	public Product save(Product product) {		
		return productRepository.save(product);
	}
	
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	public void delete(Long id) {
		productRepository.deleteById(id);
	}

}
