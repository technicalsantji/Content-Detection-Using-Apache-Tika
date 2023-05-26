package com.text.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.text.model.User;
import com.text.repository.UserRepository;

@Service
public class UserDetailsServicesImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		User user = this.userRepository.findByUsername(username);
		if (user==null) {
			System.out.println("user not found");
			throw new UsernameNotFoundException("no user found");
		}
		
		return user;
	}

}
