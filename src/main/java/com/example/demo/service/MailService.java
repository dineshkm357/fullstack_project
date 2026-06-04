package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;

@Service
public class MailService {

@Autowired
private JavaMailSender sender;

public void send(

String email,

String name

){

System.out.println("MAIL START");

try{

SimpleMailMessage msg=

new SimpleMailMessage();

msg.setFrom(

"dineshkm357@gmail.com"

);

msg.setTo(email);

msg.setSubject(

"Registration Success"

);

msg.setText(

"Hello "+name

);

sender.send(msg);

System.out.println(

"MAIL SUCCESS"

);

}catch(Exception e){

System.out.println(

"MAIL FAILED"

);

e.printStackTrace();

}

}

}