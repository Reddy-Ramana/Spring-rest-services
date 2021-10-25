package com.ramana.services;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ramana.DAO.UserDao;
import com.ramana.costomexceptions.UserNotFoundException;
import com.ramana.pojo.Posts;
import com.ramana.pojo.User;

@Component
public class UserService {

	@Autowired
	UserDao userDao;

	public List<User> getAllUsers() {

		return userDao.findAllUsers();
	}

	public User getUserById(int id) {
		User user = userDao.findUserByID(id);

		if (user == null)
			throw new UserNotFoundException("id-" + id);

		return user;
	}

	public User addUser(User user) {

		return userDao.addUser(user);
	}

	public List<Posts> getPostsforUser(int id) {

		return userDao.findPostsById(id);
	}

	public ResponseEntity updatePostforUser(User user) {

		User Currentuser = userDao.findUserByID(user.getId());
		if (Currentuser != null) {

			Currentuser = userDao.updatePostforUser(Currentuser, user);

		} else {
			user.setId(userDao.getId());
			userDao.updatePostId(user);
			Currentuser = userDao.addUser(user);
		}

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

		return ResponseEntity.created(uri).body(Currentuser);
	}

	public Posts getPostforUserById(int id, int postId) {

		User user = getUserById(id);
		List<Posts> posts = user.getPosts();
		for (Posts post : posts) {
			if (post.getId() == postId)
				return post;
		}

		throw new UserNotFoundException("not found any post for post -id " + postId);
	}

	public ResponseEntity deleteUserById(int id) {

		User user = userDao.deleteUserbyId(id);

		if (null != user) {
			System.out.println(user);
			return ResponseEntity.noContent().build();
		}
		throw new UserNotFoundException("user with id - " + id + " Not found");
	}
}
