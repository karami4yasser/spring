package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name="Producttest")
public class Product {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String image;
	private String category;
	private Long price;
	private String description;
	
	
}
