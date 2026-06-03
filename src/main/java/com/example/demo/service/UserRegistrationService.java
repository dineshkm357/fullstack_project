package com.example.demo.service;

import com.example.demo.entity.User;

import com.example.demo.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

@Autowired
private UserRepo repo;

public String register(
User user
){

repo.save(
user
);

return
"Registration Success";

}

}