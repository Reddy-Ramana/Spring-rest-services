package com.ramana.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ramana.pojo.User;
import com.ramana.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(path = "/get-all-users")
	public List<User> getAllUsers() {

		return userService.getAllUsers();
	}

	@GetMapping(path = "/get-user/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUserById(id);
	}

	@PostMapping(path = "/add-user")
	private void addUser(@RequestBody User user) {
		userService.addUser(user);
	}

}
