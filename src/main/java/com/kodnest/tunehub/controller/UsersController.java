package com.kodnest.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.serviceimpl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {

	@Autowired
	UserServiceImpl userImpl;

	@PostMapping("/register")
	public String addUser(@ModelAttribute User user,Model model) {
			userImpl.addUser(user);
			return "ConfirmationPage";
		
	}

	@PostMapping("/login")
	public String validateUser(@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("role") String role, Model model,HttpSession session) {
		session.setAttribute("email", email);
		String user = userImpl.validateUser(email, password, role);
		if (user == "Admin") {
			String name = userImpl.getUserName(email);
			model.addAttribute("name", name);
			return "Admin";
		} else if (user == "Customer") {
			String name = userImpl.getUserName(email);
			model.addAttribute("name", name);
			return "Customer";
		}
		else {
			model.addAttribute("error", "Invalid email or password");
			return "Login";
		}

	}

}
