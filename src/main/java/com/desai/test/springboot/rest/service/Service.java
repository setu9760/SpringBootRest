package com.desai.test.springboot.rest.service;

import java.util.Collection;

import com.desai.test.springboot.rest.model.User;

public interface Service {

	User getUserById(long id);
	
	void addUser(User user);
	
	Collection<User> getAllUsers();
	
	boolean isExistingUser(long id);

	void removeUser(long id);
}
