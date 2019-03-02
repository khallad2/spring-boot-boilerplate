package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.model.User;
import com.example.demo.resource.UserResource;
import com.example.repository.UsersRepo;

@SpringBootApplication
@EnableJpaRepositories("com.example.repository")
@ComponentScan(basePackageClasses = {UserResource.class, UsersRepo.class, User.class})

public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

//@EnableAutoConfiguration
//@ComponentScan({"com.example.model", "com.example.resources", "com.example.repository"})
//@EntityScan("com.example.demo.model")