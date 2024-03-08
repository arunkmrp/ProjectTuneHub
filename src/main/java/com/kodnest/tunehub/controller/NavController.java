package com.kodnest.tunehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;


@Controller
public class NavController {
	@GetMapping("/registerationpage")
	public String showRegistrationPage() {
		return "Registration";
	}
	
	@GetMapping("/loginpage")
	public String showLoginPage() {
		return "Login";
	}
	
	@GetMapping("/addnewsongs")
	public String addnewsongs() {
		return "AddSongs";
	}
	
	@GetMapping("/displaysubscription")
	public String displaysubsxription() {
		return "Subscription";
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "Login";
	}
	
	

	
}
