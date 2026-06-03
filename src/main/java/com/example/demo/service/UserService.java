package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

import com.example.demo.repository.UserRepository;

@Service
public class UserService {

@Autowired
private UserRepository repo;



public String register(

User user

){

if(

repo.existsByUsername(

user.getUsername()

)

){

return
"User Exists";

}


user.setRole(

"USER"

);


repo.save(

user

);

return

"Registration Success";

}



public String login(

String username,

String password

){

Optional<User> db =

repo.findByUsername(

username

);

if(

db.isEmpty()

){

return null;

}

User user =

db.get();

if(

!user.getPassword()

.equals(

password

)

){

return null;

}

return

user.getRole();

}

}