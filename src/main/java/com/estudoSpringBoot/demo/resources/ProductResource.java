package com.estudoSpringBoot.demo.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudoSpringBoot.demo.entities.Product;
import com.estudoSpringBoot.demo.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = productService.findAll();		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Optional<Product> product = productService.findById(id);
		if(product.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
			return ResponseEntity.ok(product.get());
	}
	
	@PostMapping
	public ResponseEntity<Product> save(@RequestBody Product product) {
		Product newProduct = productService.save(product);
		return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Product> update(@RequestBody Product product) {
		Product updateProduct =  productService.save(product);
		return ResponseEntity.ok().body(updateProduct);
	}
	   
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		productService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
