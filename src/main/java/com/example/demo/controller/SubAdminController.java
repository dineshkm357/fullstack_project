package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class SubAdminController {

@GetMapping(
"/subadmin/dashboard"
)

public String sub(

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
"Welcome To Dashboard Sub Admin";

}

}