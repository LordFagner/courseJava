package com.FagCorps.course.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FagCorps.course.entites.Product;
import com.FagCorps.course.service.ProductService;

@RestController
@RequestMapping(value = "/Product")
public class ProductResorce {
	
	@Autowired
	private ProductService service;
	
	
	
	@GetMapping
	public ResponseEntity<List<Product>> FindAll(){
		
		
		return ResponseEntity.ok().body(service.plam()); 
		
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> FindById(@PathVariable Long id){
		Product obj = service.FindById(id);
		
		return ResponseEntity.ok().body(obj); 
		
	}
	
	
}
