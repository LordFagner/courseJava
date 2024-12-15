package com.FagCorps.course.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FagCorps.course.entites.OrderItem;
import com.FagCorps.course.service.OrderItemService;

@RestController
@RequestMapping(value = "/OrdersItem")
public class OrderItemResorce2 {
	
	@Autowired
	private OrderItemService service;
	
	
	
	@GetMapping
	public ResponseEntity<List<OrderItem>> FindAll(){
		
		
		return ResponseEntity.ok().body(service.plam()); 
		
	}
	
	
	
	
	
}
