package com.springsecurityjwt;

import com.springsecurityjwt.modal.User;
import com.springsecurityjwt.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtApplication {
	@Autowired
	private UserRepository repository;
//The @PostConstruct annotation is used on a method that needs to be executed after dependency injection is done to perform any initialization.
	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
				new User(101, "ahmed", "password", "ahmedhassan@gmail.com"),
				new User(102, "user1", "pwd1", "user1@gmail.com"),
				new User(103, "user2", "pwd2", "user2@gmail.com"),
				new User(104, "user3", "pwd3", "user3@gmail.com")
		).collect(Collectors.toList());
		repository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

}
