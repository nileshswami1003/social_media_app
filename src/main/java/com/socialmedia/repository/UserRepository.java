package com.socialmedia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.socialmedia.entity.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);

	@Query("SELECT u FROM User u WHERE u.id=:uid")
	public User findById(@Param("uid") Integer uid);
	
	@Query("SELECT u FROM User u WHERE u.fname LIKE %:query% OR u.lname LIKE %:query% OR u.email LIKE %:query%")
	public List<User> searchUser(@Param("query") String query);

	@Modifying
	@Query("delete from User u where u.id=:uid")
	@Transactional
	public void deleteById(@Param("uid") Integer uid);
}
