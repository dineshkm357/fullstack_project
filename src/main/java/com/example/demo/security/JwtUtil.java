package com.example.demo.security;

import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

import java.util.Date;

@Component
public class JwtUtil {

private static final String SECRET =

"mysecretkeymysecretkeymysecretkey12";

public String createToken(

String username,

String role

){

return Jwts

.builder()

.subject(
username
)

.claim(
"role",
role
)

.issuedAt(
new Date()
)

.expiration(

new Date(

System.currentTimeMillis()

+

86400000

)

)

.signWith(

Keys.hmacShaKeyFor(

SECRET.getBytes(

StandardCharsets.UTF_8

)

)

)

.compact();

}

}