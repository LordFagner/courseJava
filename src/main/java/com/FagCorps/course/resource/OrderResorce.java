package com.FagCorps.course.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FagCorps.course.entites.Order;
import com.FagCorps.course.service.OrderService;

@RestController
@RequestMapping(value = "/Orders")
public class OrderResorce {
	
	@Autowired
	private OrderService service;
	
	
	
	@GetMapping
	public ResponseEntity<List<Order>> FindAll(){
		
		
		return ResponseEntity.ok().body(service.plam()); 
		
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> FindById(@PathVariable Long id){
		Order obj = service.FindById(id);
		
		return ResponseEntity.ok().body(obj); 
		
	}
	
	
}
