package com.FagCorps.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FagCorps.course.Repositorys.UserRepository;
import com.FagCorps.course.entites.User;
import com.FagCorps.course.service.excpetion.DatabaseExpction;
import com.FagCorps.course.service.excpetion.ResourceNotFoundExpetion;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public List<User> plam() {

		return repository.findAll();

	}

	public User FindById(Long id) {

		Optional<User> uuser = repository.findById(id);

		return uuser.orElseThrow(() -> new ResourceNotFoundExpetion(id));

	}

	public User Insert(User obj) {

		return repository.save(obj);

	}

	public void delete(Long id) {

		Optional<User> user = repository.findById(id);

		repository.delete(user.orElseThrow(() -> new DatabaseExpction(id)));

	}

	public User update(Long id, User user) {
		
		try {
			User entity = repository.getReferenceById(id);
			UpdateData(entity, user);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			 throw new ResourceNotFoundExpetion(id);
		}

	
		
		}

	private void UpdateData(User entity, User obj) {

		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setNumber(obj.getNumber());

	}

}
