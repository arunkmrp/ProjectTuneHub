package com.kodnest.tunehub.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.repository.UserRepository;
import com.kodnest.tunehub.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public void addUser(User user) {
		userRepository.save(user);

	}

	@Override
	public String validateUser(String email, String password, String role) {

		User user = userRepository.findByEmail(email);

		if (user != null && user.getPassword().equals(password)&& user.getRole().equals(role))
			if(user.getRole().equals("Admin"))
			  return "Admin";
		if (user != null && user.getPassword().equals(password)&& user.getRole().equals(role))
			if(user.getRole().equals("Customer"))
			return "Customer";
		return "false";
	}

	@Override
	public String getUserName(String email) {
		User user = userRepository.findByEmail(email);
		return user.getName();
	}
	
	@Override
	public String emailExists(String email) {
		User user = userRepository.findByEmail(email);
		return user.getEmail();
	}

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}

}
