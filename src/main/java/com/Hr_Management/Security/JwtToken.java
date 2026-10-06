package com.Hr_Management.Security;

import java.security.Key;
import java.util.Date;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.Hr_Management.Enum.Permissions;
import com.Hr_Management.Enum.Role;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtToken {

	private final Key key;
	private final long tokenexpire=1000L*60*60*12;
	
	public JwtToken() {
		String token=System.getenv("JWT_SECRET");
		if(token==null || token.isEmpty()) {
			token="Replace with token in placeholder";
		}
		key=Keys.
				hmacShaKeyFor(token.getBytes());
	}
	public String generatedToken(String userName,Role role) {
		Set<Permissions> permission=RoleBasedPermissions.getRoleBasedPermissions()
				.get(role);
		return Jwts.builder()
				.subject(userName)
				.claim("Role", role.name())
				.claim("Permissions", permission)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis()+tokenexpire))
				.signWith(key)
				.compact();
		
	}
	
	
	public String extractUsername(String token) {
	    return Jwts.parser()
	            .verifyWith((javax.crypto.SecretKey) key)
	            .build()
	            .parseSignedClaims(token)
	            .getPayload()
	            .getSubject();
	}

	public boolean isTokenValid(String token) {
	    try {
	        Jwts.parser()
	                .verifyWith((javax.crypto.SecretKey) key)
	                .build()
	                .parseSignedClaims(token);

	        return true;

	    } catch (Exception e) {
	        return false;
	    }
	}
}
