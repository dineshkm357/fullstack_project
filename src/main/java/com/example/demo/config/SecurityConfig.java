package com.example.demo.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

@Bean
public SecurityFilterChain security(

HttpSecurity http

)

throws Exception{

http

.cors(
cors->{}
)

.csrf(

csrf->

csrf.disable()

)

.authorizeHttpRequests(

auth->

auth

.requestMatchers(

"/login",

"/logout",

"/swagger-ui/**",

"/swagger-ui.html",

"/v3/api-docs/**"

)

.permitAll()

.anyRequest()

.permitAll()

)

.formLogin(

form->

form.disable()

)

.httpBasic(

basic->

basic.disable()

);

return

http.build();

}

}