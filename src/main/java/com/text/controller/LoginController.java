package com.text.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.text.model.User;
import com.text.repository.UserRepository;
import com.text.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserRepository ueRepository;
	
	@PostMapping("/datalogs")
    public User getUser(@RequestBody User user){
       User user1 = this.ueRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
       return user1;
      
	}
}
