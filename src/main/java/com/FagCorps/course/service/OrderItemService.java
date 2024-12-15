package com.FagCorps.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FagCorps.course.Repositorys.OrderItemRepository;
import com.FagCorps.course.entites.Order;
import com.FagCorps.course.entites.OrderItem;
import com.FagCorps.course.entites.Pk.OrderItemPk;
@Service
public class OrderItemService {
@Autowired
	private OrderItemRepository repository;


public List<OrderItem> plam(){
	
	
	
	
	return repository.findAll();
	
	
}












}
