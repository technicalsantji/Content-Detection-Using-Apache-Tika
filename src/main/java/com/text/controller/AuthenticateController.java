package com.text.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.text.SecurityConfig.JwtUtil;
import com.text.model.JwtRequest;
import com.text.model.JwtResponse;
import com.text.model.User;
import com.text.service.UserDetailsServicesImpl;
@CrossOrigin("*")
@RestController
public class AuthenticateController {

	
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsServicesImpl userDetailsServicesImpl;
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		try {
			authencate(jwtRequest.getUsername(), jwtRequest.getPassword());
			
		} catch (UsernameNotFoundException e) {
			// TODO: handle exception
			throw new Exception("User  not Found");
		}
		
		UserDetails userDetails = this.userDetailsServicesImpl.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
	
	
	
	private void authencate(String username,String pasasword) throws Exception {
		
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, pasasword));
			
		} catch (DisabledException e) {
			throw new Exception("USER DISABLED");
		}catch (BadCredentialsException e) {
			throw new Exception("Invalid Credential ");
		}
	}
	
	
	@GetMapping("/current")
	public User getCurrentUser(Principal principal) {
		return ( (User) this.userDetailsServicesImpl.loadUserByUsername(principal.getName()));
		
	}
	
	
	
}
