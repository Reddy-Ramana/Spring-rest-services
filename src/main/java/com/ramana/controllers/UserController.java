package com.ramana.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ramana.costomexceptions.UserNotFoundException;
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

	@GetMapping(path = "/user/{id}")
	public User getUser(@PathVariable int id) {
		User user = userService.getUserById(id);

		if (user == null)
			throw new UserNotFoundException("id-" + id);

		return user;
	}

	@PostMapping(path = "/user")
	private ResponseEntity<User> addUser(@RequestBody User user) {
		User addedUser = userService.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addedUser.getId())
				.toUri();
		return ResponseEntity.created(location).body(addedUser);
	}

}
