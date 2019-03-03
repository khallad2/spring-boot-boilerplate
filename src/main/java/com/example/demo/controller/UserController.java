package com.example.demo.resource;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
	public List<User> users() {
		return userService.users();
	}
	
	@PutMapping("/find/{id}")
	public User find(@PathVariable Integer id, @RequestBody User user) {
		return userService.find(id, user);
	}
	
	@PostMapping("/create")
	public User save(@Valid @RequestBody User user) {
		return userService.save(user);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> update(@PathVariable("id") Integer id,@RequestBody User user) {	
			System.out.print(userService.find(id, user));	
			return userService.update(id, user);
	}
	
	@DeleteMapping("/delete/{id}")
	public Optional<User> delete(@PathVariable("id") Integer id) {
		Optional<User> res = userService.delete(id);
		return res;
	}
}
