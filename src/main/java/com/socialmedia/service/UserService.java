package com.socialmedia.service;

import java.util.List;

import com.socialmedia.entity.User;

public interface UserService {

	List<User> selectAllUsers();
	
	User insertUser(User user);
	
	User selectUserById(Integer id);
	
	User selectUserByEmail(String email);
	
	User updateUser(Integer id, User user);
	
	void deleteUser(Integer id);
	
	User followUser(Integer id1, Integer id2);
	
	List<User> searchUser(String query);
}
