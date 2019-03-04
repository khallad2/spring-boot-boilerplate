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
		Optional<User> usr = usersRepo.findById(id);
		if(!usr.isPresent()) {
			return null;
		} else {
			return usersRepo.save(user);	
		}
	}
	
	public Optional<User> delete(Integer id) {
		Optional<User> res = usersRepo.findById(id);
		usersRepo.deleteById(id);
		return res;
	}
}
