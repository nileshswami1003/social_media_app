package com.socialmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.entity.User;
import com.socialmedia.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserRepository repository;
	
	@Override
	public List<User> selectAllUsers() {
		return repository.findAll();
	}

	@Override
	public User insertUser(User user) {
		return repository.save(user);
	}

	@Override
	public User selectUserById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public User selectUserByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public User updateUser(Integer id, User user) {
		user.setId(id);
		return repository.save(user);
	}

	@Override
	public void deleteUser(Integer id) {
		repository.deleteById(id);		
	}

	@Override
	public User followUser(Integer id1, Integer id2) {
		// id1 want to follow id2
		User user1 = this.selectUserById(id1);
		User user2 = this.selectUserById(id2);
		//update user2's followers list
		user2.getFollowers().add(user1.getId());
		//update user1's following list
		user1.getFollowings().add(user2.getId());
		//update into database
		repository.save(user1);
		repository.save(user2);
		return user1;     // user1 wants to follow hence returned the same
	}

	@Override
	public List<User> searchUser(String query) {
		return repository.searchUser(query);
	}

}
