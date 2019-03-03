package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repository.UsersRepo;

@Service
public class UserService {
	@Autowired
	UsersRepo usersRepo;
	
	public List<User> getAll() {
		return usersRepo.findAll();
	}
	
	public User find(Integer id, User user) {
		return usersRepo.findById(id).get();
	}
	
	public User save(User user) {
		return usersRepo.save(user);
	}
	
	public User update(Integer id, User user) {	
		return usersRepo.save(user);
	}
	
//	public ResponseEntity<Object> update(Integer id, User user) {	
////		try {
//			if(usersRepo.findById(id).isPresent()) {
//				User toBeUpdated = user;
//				return new ResponseEntity<Object>(usersRepo.save(toBeUpdated), HttpStatus.OK);	
//			} else {
//				return new ResponseEntity<Object>("message:" + "User not found", HttpStatus.BAD_REQUEST);
//			}
////		} catch(NoSuchElementException ex) {
////			return new ResponseEntity<Object>("message:" + "User not found", HttpStatus.BAD_REQUEST);
////		}
//
////		System.out.print(usersRepo.findById(id));
////		if(usersRepo.findById(id).isPresent()) {
////			User updatedUser = usersRepo.save(user);
////			return new ResponseEntity<Object>(updatedUser, HttpStatus.OK);
////		} else {
//////			System.out.print(usersRepo.findById(id).isPresent());	
////			return new ResponseEntity<Object>("message:" + "User not found", HttpStatus.BAD_REQUEST);
//////			throw new UserNotFoundException(); 
////		}
//	}
	
	public Optional<User> delete(Integer id) {
		Optional<User> res = usersRepo.findById(id);
		usersRepo.deleteById(id);
		return res;
	}
}
