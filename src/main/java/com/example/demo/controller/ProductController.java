package com.example.demo.controller;
import com.example.demo.model.Category;
import  com.example.demo.model.Product;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api")
public class ProductController {
	
	
	@Autowired
	private ProductRepository ProductRepository; 
  
	
	@GetMapping("/products")
	List<Product> getProducts(){
		return ProductRepository.findAll();
	}
	@GetMapping("/products/category/{category}")
	List<Product> getproductsByCategory(@PathVariable String category){
	List<Product> Product = ProductRepository.findByCategory(category);
	 return Product;
	 
	}
	@GetMapping("/product/{id}")
	ResponseEntity<?> getCategory(@PathVariable Long id){
	Optional<Product> Product = ProductRepository.findById(id);
	 return Product.map(response -> ResponseEntity.ok().body(response))
			 .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	 
	}

	@DeleteMapping("/product/{id}")
	ResponseEntity<?>  deleteProduct(@PathVariable Long id){
		ProductRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/product")
	ResponseEntity<Product> createExpense(@Validated @RequestBody Product product) throws URISyntaxException{
		Product result= ProductRepository.save(product);
		return ResponseEntity.created(new URI("/api/products" + result.getId())).body(result);
	}
}
