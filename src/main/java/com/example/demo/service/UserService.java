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

@Autowired
private MailService mail;



public String register(

User user

){

System.out.println(

"REGISTER START"

);

if(

repo.existsByUsername(

user.getUsername()

)

){

return
"User Exists";

}


/* FORCE USER ROLE */

user.setRole(

"USER"

);


/* SAVE */

User saved=

repo.save(

user

);

System.out.println(

"ROLE -> "

+

saved.getRole()

);


/* SEND MAIL */

try{

mail.send(

saved.getEmail(),

saved.getName()

);

System.out.println(

"MAIL SENT"

);

}

catch(

Exception e

){

e.printStackTrace();

}


return

"Registration Success";

}



public String login(

String username,

String password

){

Optional<User> db=

repo.findByUsername(

username

);

if(

db.isEmpty()

){

return null;

}

User user=

db.get();

if(

!user.getPassword()

.equals(

password

)

){

return null;

}


/* RETURN ROLE */

return

user.getRole();

}

}