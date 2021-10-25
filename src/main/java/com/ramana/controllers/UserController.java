package com.ramana.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ramana.costomexceptions.UserNotFoundException;
import com.ramana.pojo.Posts;
import com.ramana.pojo.User;
import com.ramana.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(path = "/get-all-users")
	public List<User> getAllUsers() {

		List<User> allUsers = userService.getAllUsers();
		if (allUsers.isEmpty())
			throw new UserNotFoundException("No Users Found");
		return allUsers;
	}

	@GetMapping(path = "/user/{id}")
	public User getUser(@PathVariable int id) {

		return userService.getUserById(id);
	}

	@PostMapping(path = "/user")
	private ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User addedUser = userService.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addedUser.getId())
				.toUri();
		return ResponseEntity.created(location).body(addedUser);
	}

	@GetMapping(path = "/user/{id}/posts")
	public List<Posts> getPostsById(@PathVariable int id) {
		return userService.getPostsforUser(id);
	}

	@PostMapping(path = "/user/post")
	public ResponseEntity updatePostforUser(@RequestBody User user) {
		return userService.updatePostforUser(user);
	}

	@GetMapping(path = "/user/{id}/posts/{postId}")
	public Posts getUserPostByID(@PathVariable int id, @PathVariable int postId) {

		return userService.getPostforUserById(id, postId);
	}

	@DeleteMapping(path = "/user/{id}")
	private ResponseEntity deleteUserById(@PathVariable int id) {

		return userService.deleteUserById(id);
	}
}
