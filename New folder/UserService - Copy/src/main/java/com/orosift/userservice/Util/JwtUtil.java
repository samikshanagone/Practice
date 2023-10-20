package com.orosift.userservice.Util;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;

	
	public String generateToken(String secretBytes) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + expiration);
		Key SECRET_KEY = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
		 String token = Jwts.builder()
	                .setSubject(secretBytes)
	                .setExpiration(expiryDate)
	                .signWith(SECRET_KEY)
	                .compact();
	        return token;
	}
}
