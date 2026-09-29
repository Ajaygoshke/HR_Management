package com.Hr_Management.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Hr_Management.Security.JwtToken;
import com.Hr_Management.model.UserAuth;
import com.Hr_Management.repositry.UserAuthrepo;

@Service
public class userAuthService {

	private final UserAuthrepo repo;
	private final JwtToken jwttoken;
	
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	
	public userAuthService (UserAuthrepo repo,JwtToken jwttoken) {
		this.repo=repo;
		this.jwttoken=jwttoken;
	}
	
	public UserAuth addEmp(UserAuth userAuth) {
		// TODO Auto-generated method stub
		userAuth.setPassword(encoder.encode(userAuth.getPassword()));
		return repo.save(userAuth);
	}

	public String login(String userEmail, String password) {
		// TODO Auto-generated method stub
		
		UserAuth userAuth=repo.findByUserEmail(userEmail).orElse(null);
		if(userAuth==null) return "User Not Found";
		if(!encoder.matches(password, userAuth.getPassword())) {
			return "Invalid coardincationsal";
		}
		return jwttoken.generatedToken(userAuth.getUserEmail(), userAuth.getRole());
	}

}
