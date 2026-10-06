package com.Hr_Management.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Hr_Management.model.LoginRequest;
import com.Hr_Management.model.UserAuth;
import com.Hr_Management.service.userAuthService;


@Controller
@RestController
public class UserAuthController {
	
	private final userAuthService service;
	
	
	public UserAuthController(userAuthService service) {
		this.service=service;
	}
	@GetMapping("/employees")
	public String employees() {
	    return "Employee data";
	}
	
	@PostMapping("/add")
	public UserAuth postMethodName(@RequestBody UserAuth userAuth) {
		//TODO: process POST request
		
		return service.addEmp(userAuth);
	}
	
	@PostMapping("/login")
	public String postMethodName1(@RequestBody LoginRequest loginRequest) {
		//TODO: process POST request
		
		return service.login(
                loginRequest.getUserEmail(),
                loginRequest.getPassword());
	}
	
	

}
