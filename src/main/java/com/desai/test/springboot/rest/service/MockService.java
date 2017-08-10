package com.desai.test.springboot.rest.service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.desai.test.springboot.rest.model.User;

public class MockService implements Service {

	private Map<Long, User> inMemoryUsers = new HashMap<>();

	public MockService() {
		for (int i = 0; i < 5; i++) {
			inMemoryUsers.put(new Long(i), new User(i, "f_name-" + i, "l_name-" + i, "dept" + i));
		}
	}

	@Override
	public User getUserById(long id) {
		return inMemoryUsers.get(id);
	}

	@Override
	public void addUser(User user) {
		inMemoryUsers.putIfAbsent(user.getId(), user);
	}

	@Override
	public Collection<User> getAllUsers() {
		return Collections.unmodifiableCollection(inMemoryUsers.values());
	}

	@Override
	public boolean isExistingUser(long id) {
		return inMemoryUsers.containsKey(id);
	}

	@Override
	public void removeUser(long id) {
		inMemoryUsers.remove(id);
	}
}
