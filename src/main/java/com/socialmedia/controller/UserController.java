package com.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.entity.User;
import com.socialmedia.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/list")
	public List<User> getAllUsers() {
		return userService.selectAllUsers();
	}
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		userService.insertUser(user);
		return user;
	}
	
	@GetMapping("/get/{id}")
	public User getUserById(@PathVariable Integer id) {
		return userService.selectUserById(id);
	}
	
	@GetMapping("/{email}")
	public User getUserByEmail(@PathVariable String email) {
		return userService.selectUserByEmail(email);
	}
	
	@PutMapping("/update/{id}")
	public User updateUser(@PathVariable Integer id,@RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
	}
	
	@PutMapping("/follow/{id1}/{id2}")
	public User followUser(@PathVariable Integer id1, @PathVariable Integer id2) {
		return userService.followUser(id1, id2);
	}
	
	@GetMapping("/search/{query}")
	public List<User> searchUserList(@PathVariable String query){
		return userService.searchUser(query);
	}
}
