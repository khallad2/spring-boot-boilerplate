package com.example.demo.resource;



import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.repository.UsersRepo;

import exception.UserNotFoundException;

@RestController
@RequestMapping("users")
public class UserResource {
	@Autowired
	UsersRepo usersRepo;
	
	@GetMapping("/all")
	public List<User> users() {
		return usersRepo.findAll();
	}
	
	@PutMapping("/find/{id}")
	public User find(@PathVariable Integer id, @RequestBody User user) {
		return usersRepo.findById(id).get();
	}
	
	@PostMapping("/create")
	public User save(@Valid @RequestBody User user) {
		return usersRepo.save(user);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> update(@PathVariable("id") Integer id,@RequestBody User user) {	
		if(usersRepo.findById(id).isPresent()) {
			User m = usersRepo.save(user);
			return new ResponseEntity<Object>(m, HttpStatus.OK); // usersRepo.findById(id);
		} else {
			System.out.print(usersRepo.findById(id).isPresent());	
//			return new ResponseEntity<user>("message:" + "User not found", HttpStatus.BAD_REQUEST); // usersRepo.findById(id);
			throw new UserNotFoundException(); 
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public Optional<User> delete(@PathVariable("id") Integer id) {
		Optional<User> res = usersRepo.findById(id);
		usersRepo.deleteById(id);
		return res;
	}
}
