package com.capgemini.onlinetestmanagement.services;

import java.util.List;

import com.capgemini.onlinetestmanagement.entity.User;

public interface UserServiceInterface {
	
	boolean addUser(User user);
    List<User> showAllUsers();
	void deleteuser(long userId);
	java.util.Optional<User> findUserById(Long userId);
	
}
