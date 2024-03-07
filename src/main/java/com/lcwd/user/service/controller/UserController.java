package com.lcwd.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
//	create user
	@PostMapping()
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
//	get all user
	@GetMapping()
	public ResponseEntity<List<User>>getAllUser(){
		List<User> users = userService.getAllUser();
		return  new ResponseEntity<>(users,HttpStatus.OK);
	}
	
//	get user by id
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable String userId ){
		User user2 = userService.getUserById(userId);
		return new ResponseEntity<>(user2,HttpStatus.OK) ;
	}
}
