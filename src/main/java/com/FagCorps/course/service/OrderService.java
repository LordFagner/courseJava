package com.FagCorps.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FagCorps.course.Repositorys.OrderRepository;
import com.FagCorps.course.Repositorys.UserRepository;
import com.FagCorps.course.entites.Order;
import com.FagCorps.course.entites.User;
import com.FagCorps.course.resource.OrderResorce;
@Service
public class OrderService {
@Autowired
	private OrderRepository repository;


public List<Order> plam(){
	
	
	
	
	return repository.findAll();
	
	
}


public Order FindById(Long id) {
	
	Optional<Order> uuser = repository.findById(id);
	
	
	
	return uuser.get();
	
	
	
	
}










}
