package com.FagCorps.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FagCorps.course.Repositorys.ProductRepository;
import com.FagCorps.course.entites.Product;
@Service
public class ProductService {
@Autowired
	private ProductRepository repository;


public List<Product> plam(){
	
	
	
	
	return repository.findAll();
	
	
}


public Product FindById(Long id) {
	
	Optional<Product> uProduct = repository.findById(id);
	
	
	
	return uProduct.get();
	
	
	
	
}










}
