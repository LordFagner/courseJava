package com.FagCorps.course.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FagCorps.course.entites.Category;
import com.FagCorps.course.entites.Order;
import com.FagCorps.course.service.CategoryService;
import com.FagCorps.course.service.OrderService;

@RestController
@RequestMapping(value = "/Category")
public class CategoryResorce {
	
	@Autowired
	private CategoryService service;
	
	
	
	@GetMapping
	public ResponseEntity<List<Category>> FindAll(){
		
		
		return ResponseEntity.ok().body(service.plam()); 
		
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> FindById(@PathVariable Long id){
		Category obj = service.FindById(id);
		
		return ResponseEntity.ok().body(obj); 
		
	}
	
	
}
