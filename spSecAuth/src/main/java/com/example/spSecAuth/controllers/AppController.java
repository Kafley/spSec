package com.example.spSecAuth.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Spring Security class";
		
	}
	@GetMapping("/hello")
	public String hello() {
		return "Hello! This is spring security class.";
		
	}
	@GetMapping("")
	public String defaultMethod() {
		return "This is spring Security.";
		
	}
	
}
