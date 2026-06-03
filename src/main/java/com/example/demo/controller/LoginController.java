package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class LoginController {

@Autowired
private UserService service;

@Autowired
private JwtUtil jwt;

private static boolean LOGOUT=false;



@PostMapping("/login")

public Map<String,Object> login(

@RequestBody LoginRequest req

){

String role =

service.login(

req.getUsername(),

req.getPassword()

);

if(role==null){

return Map.of(

"message",

"Invalid Login"

);

}

LOGOUT=false;

String token=

jwt.createToken(

req.getUsername(),

role

);

return Map.of(

"message",

"Login Success",

"role",

role,

"token",

token

);

}



@PostMapping("/logout")

public Map<String,String> logout(){

LOGOUT=true;

return Map.of(

"message",

"Logout Success"

);

}



public static boolean isLogout(){

return LOGOUT;

}

}