package com.desai.test.springboot.rest.controller;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.desai.test.springboot.rest.model.User;
import com.desai.test.springboot.rest.service.MockService;
import com.desai.test.springboot.rest.service.Service;

@RequestMapping("/rest/user")
@org.springframework.web.bind.annotation.RestController
public class RestController {

	private Service service = new MockService();

	@RequestMapping("/hello")
	public ResponseEntity<String> hello() {
		return new ResponseEntity<>("hello", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody User user) {
		if (!service.isExistingUser(user.getId())) {
			service.addUser(user);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable long id, @RequestBody User user){
		if (!service.isExistingUser(user.getId()))
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		service.addUser(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable long id){
		if (!service.isExistingUser(id))
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		service.removeUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable long id) {
		User u = service.getUserById(id);
		if (null == u)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(u, HttpStatus.OK);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<Collection<User>> getAllUser() {
		return new ResponseEntity<Collection<User>>(service.getAllUsers(), HttpStatus.OK);
	}
}
