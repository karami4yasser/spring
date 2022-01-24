package com.example.demo.repository;
import  com.example.demo.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Category;

public interface ProductRepository extends JpaRepository<Product,Long> {
	List<Product> findByCategory(String category);
}
