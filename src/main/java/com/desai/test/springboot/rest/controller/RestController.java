package com.desai.test.springboot.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/rest")
@org.springframework.web.bind.annotation.RestController
public class RestController {

	@RequestMapping("/hello")
	public ResponseEntity<String> hello(){
		return new ResponseEntity<>("hello", HttpStatus.OK);
	}
	
}
