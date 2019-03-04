package com.example.demo.controller;

import java.util.List;
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
import com.example.demo.service.*;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/all")
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<List<User>>(userService.getAll(), HttpStatus.OK);
	}
	
	@PutMapping("/find/{id}")
	public ResponseEntity<Object> find(@PathVariable Integer id, @RequestBody User user) {
		return new ResponseEntity<Object>(userService.find(id, user), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> save(@Valid @RequestBody User user) {
		return new ResponseEntity<Object>(userService.save(user), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> update(@PathVariable("id") Integer id,@RequestBody User user) {
		User myUser = userService.update(id, user);
		if( myUser == null) {
			return new ResponseEntity<Object>("User Not Found", HttpStatus.BAD_REQUEST);	
		} else {
			return new ResponseEntity<Object>(userService.update(id, user), HttpStatus.OK);	
		}		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
		return new ResponseEntity<Object>(userService.delete(id), HttpStatus.OK);
	}
}
