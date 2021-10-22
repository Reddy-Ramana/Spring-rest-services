package com.ramana.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ramana.DAO.UserDao;
import com.ramana.pojo.User;

@Component
public class UserService {

	@Autowired
	UserDao userDao;

	public List<User> getAllUsers() {

		return userDao.findAllUsers();
	}

	public User getUserById(int id) {

		return userDao.findUserByID(id);
	}

	public User addUser(User user) {

		return userDao.addUser(user);
	}
}
