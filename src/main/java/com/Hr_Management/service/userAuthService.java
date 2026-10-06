package com.Hr_Management.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Hr_Management.Security.JwtToken;
import com.Hr_Management.model.UserAuth;
import com.Hr_Management.repositry.UserAuthrepo;

@Service
public class userAuthService implements UserDetailsService {

    private final UserAuthrepo repo;
    private final JwtToken jwttoken;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public userAuthService(UserAuthrepo repo, JwtToken jwttoken) {
        this.repo = repo;
        this.jwttoken = jwttoken;
    }

    public UserAuth addEmp(UserAuth userAuth) {

        userAuth.setPassword(
            encoder.encode(userAuth.getPassword())
        );

        return repo.save(userAuth);
    }

    public String login(String userEmail, String password) {

        UserAuth userAuth =
            repo.findByUserEmail(userEmail).orElse(null);

        if (userAuth == null)
            return "User Not Found";

        if (!encoder.matches(password, userAuth.getPassword())) {
            return "Invalid credentials";
        }

        return jwttoken.generatedToken(
            userAuth.getUserEmail(),
            userAuth.getRole()
        );
    }

    // This method is used by JwtAuthenticationFilter
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserAuth userAuth = repo.findByUserEmail(username)
                .orElseThrow(() ->
                    new UsernameNotFoundException(
                        "User not found: " + username
                    )
                );

        return User.builder()
                .username(userAuth.getUserEmail())
                .password(userAuth.getPassword())
                .roles(userAuth.getRole().name())
                .build();
    }
}