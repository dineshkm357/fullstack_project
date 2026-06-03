package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;

import com.example.demo.repository.UserRepository;

@RestController
public class UserController {

@Autowired
private UserRepository repo;



@GetMapping(
"/user/dashboard"
)

public String user(

@RequestHeader(
value="Authorization",
required=false
)

String token

){

if(

token==null

||

LoginController.isLogout()

){

return
"Please Login Here";

}

return
"Welcome To Dashboard User";

}



/*
ADMIN Dashboard
User List
*/

@GetMapping(
"/user/all"
)

public List<User> allUsers(

@RequestHeader(
value="Authorization",
required=false
)

String token

){

if(

token==null

||

LoginController.isLogout()

){

return
List.of();

}

return

repo.findAll();

}

}