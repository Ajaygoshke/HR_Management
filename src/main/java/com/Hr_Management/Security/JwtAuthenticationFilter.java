package com.Hr_Management.Security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtToken jwtToken;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(
            JwtToken jwtToken,
            UserDetailsService userDetailsService) {

        this.jwtToken = jwtToken;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        // Get Authorization header
        String authHeader = request.getHeader("Authorization");

        // If token is missing, continue the request
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Remove "Bearer "
        String token = authHeader.substring(7);

        try {

            // Check whether token is valid
            if (jwtToken.isTokenValid(token)) {

                // Get username from token
                String username = jwtToken.extractUsername(token);

                // Get user from database
                UserDetails userDetails =
                        userDetailsService.loadUserByUsername(username);

                // Create authentication
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                authentication.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );

                // Tell Spring Security that user is authenticated
                SecurityContextHolder
                        .getContext()
                        .setAuthentication(authentication);
            }

        } catch (Exception e) {
            System.out.println("JWT validation failed: " + e.getMessage());
        }

        // Continue request
        filterChain.doFilter(request, response);
    }
}