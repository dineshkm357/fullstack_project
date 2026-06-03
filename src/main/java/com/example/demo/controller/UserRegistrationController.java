package com.example.demo.controller;

import com.example.demo.entity.User;

import com.example.demo.service.UserRegistrationService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping(
"/user"
)

public class UserRegistrationController {

@Autowired
private UserRegistrationService service;

@PostMapping(
"/register"
)

public String save(

@RequestBody
User user

){

return service.register(
user
);

}

}