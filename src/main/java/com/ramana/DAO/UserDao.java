package com.ramana.DAO;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ramana.pojo.User;

@Component
public class UserDao {

	private static final List<User> users = new ArrayList<>();
	private static int id = 3;

	static {
		users.add(new User(1, "Ramana", new Date()));
		users.add(new User(2, "Reddy", new Date()));
		users.add(new User(3, "Alla", new Date()));
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
}
