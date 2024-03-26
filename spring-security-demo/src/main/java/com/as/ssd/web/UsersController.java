package com.as.ssd.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.as.ssd.data.model.User;
import com.as.ssd.services.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {

	private final UserService userService;


	public UsersController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.findAll();
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.create(user);
	}
}
