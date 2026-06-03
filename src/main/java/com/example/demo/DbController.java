package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class DbController {

@Autowired
private DataSource dataSource;

@GetMapping("/db")

public String db() {

try {

return "DB Connected → "
+ dataSource
.getConnection()
.getCatalog();

}

catch(Exception e){

return "DB Failed";

}

}

}