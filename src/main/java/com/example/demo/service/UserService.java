package com.example.demo.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UsersRepo;

import com.example.demo.exception.UserNotFoundException;

@Service
public class UserService {
	@Autowired
	UsersRepo usersRepo;
	
	public List<User> users() {
		return usersRepo.findAll();
	}
	
	public User find(Integer id, User user) {
		return usersRepo.findById(id).get();
	}
	
	public User save(User user) {
		return usersRepo.save(user);
	}
	
	public ResponseEntity<Object> update(Integer id, User user) {	
		if(usersRepo.findById(id).isPresent()) {
			User m = usersRepo.save(user);
			return new ResponseEntity<Object>(m, HttpStatus.OK); // usersRepo.findById(id);
		} else {
			System.out.print(usersRepo.findById(id).isPresent());	
//			return new ResponseEntity<user>("message:" + "User not found", HttpStatus.BAD_REQUEST); // usersRepo.findById(id);
			throw new UserNotFoundException(); 
		}
	}
	
	public Optional<User> delete(Integer id) {
		Optional<User> res = usersRepo.findById(id);
		usersRepo.deleteById(id);
		return res;
	}
}
