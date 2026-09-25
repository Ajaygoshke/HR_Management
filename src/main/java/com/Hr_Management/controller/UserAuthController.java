package com.Hr_Management.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Hr_Management.model.UserAuth;
import com.Hr_Management.service.userAuthService;


@Controller
@RestController
public class UserAuthController {
	
	private final userAuthService service;
	
	
	public UserAuthController(userAuthService service) {
		this.service=service;
	}
	
	
	@PostMapping("/add")
	public UserAuth postMethodName(@RequestBody UserAuth userAuth) {
		//TODO: process POST request
		
		return service.addEmp(userAuth);
	}
	
	@PostMapping("/login")
	public String postMethodName1(@RequestBody UserAuth userAuth) {
		//TODO: process POST request
		
		return service.login(userAuth.getUserEmail(),userAuth.getPassword());
	}
	
	

}
