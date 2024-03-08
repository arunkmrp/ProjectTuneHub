package com.kodnest.tunehub.service;

import com.kodnest.tunehub.entity.User;

public interface UserService {
	void addUser(User user);

	String validateUser(String email, String password, String role);

	String getUserName(String email);

	String emailExists(String email);
	
	User getUser(String email);
	
	void updateUser(User user);
}
