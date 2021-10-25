package com.ramana.DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ramana.pojo.Posts;
import com.ramana.pojo.User;

@Component
public class UserDao {

	private static final List<User> users = new ArrayList<>();
	private static int id = 3;

	static {
		users.add(new User(1, "Ramana", new Date(), Arrays.asList(new Posts(1, new Date(), "Ramana's First Post"),
				new Posts(2, new Date(), "Ramana's Sencond Date"))));
		users.add(new User(2, "Reddy", new Date(), Arrays.asList(new Posts(1, new Date(), "Reddy's First Post"),
				new Posts(2, new Date(), "Reddy's Sencond Date"))));
		users.add(new User(3, "Alla", new Date(), Arrays.asList(new Posts(1, new Date(), "Alla's First Post"),
				new Posts(2, new Date(), "Alla's Sencond Date"))));
	}

	public List<User> findAllUsers() {
		return users;
	}

	public User findUserByID(int id) {

		for (User user : users) {

			if (user.getId() == id)
				return user;
		}
		return null;
	}

	public User addUser(User user) {

		if (user.getId() == 0)
			user.setId(++id);
		users.add(user);
		return user;
	}

	public List<Posts> findPostsById(int id) {

		for (User user : users) {
			if (user.getId() == id)
				return user.getPosts();
		}
		return null;
	}

	public User updatePostforUser(User currentuser, User user) {

		int highestPostId = getHighestPostId(currentuser.getPosts());
		for (Posts post : user.getPosts()) {
			post.setId(++highestPostId);
			currentuser.getPosts().add(post);

		}
		return currentuser;
	}

	private int getHighestPostId(List<Posts> posts) {

		int i = 0;

		for (Posts post : posts) {
			if (i > post.getId())
				i = i;
			else
				i = post.getId();
		}

		return i;

	}

	public int getId() {
		return ++id;
	}

	public User updatePostId(User user) {

		List<Posts> posts = user.getPosts();
		int postid = 0;
		for (Posts post : posts) {

			post.setId(++postid);
			postid = postid;

		}
		return user;

	}
}
