package com.FagCorps.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FagCorps.course.Repositorys.CategoryRepository;
import com.FagCorps.course.entites.Category;
@Service
public class CategoryService {
@Autowired
	private CategoryRepository repository;


public List<Category> plam(){
	
	
	
	
	return repository.findAll();
	
	
}


public Category FindById(Long id) {
	
	Optional<Category> uCategory = repository.findById(id);
	
	
	
	return uCategory.get();
	
	
	
	
}










}
