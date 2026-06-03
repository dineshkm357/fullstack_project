package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

@GetMapping(
"/admin/dashboard"
)

public String admin(

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
"Welcome To Dashboard Admin";

}

}