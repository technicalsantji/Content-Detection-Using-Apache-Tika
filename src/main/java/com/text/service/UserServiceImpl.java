package com.text.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.text.model.User;
import com.text.model.UserRole;
import com.text.repository.RoleRepository;
import com.text.repository.UserRepository;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
   private RoleRepository roleRepository;
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
     User local= this.userRepository.findByUsername(user.getUsername());
      if (local!=null){
          System.out.println("User is already there !");
          throw new Exception("User already present ");
      }else {
          for (UserRole ur:userRoles){
             roleRepository.save(ur.getRole());
          }
          user.getUserRoles().addAll(userRoles);
          local = this.userRepository.save(user);
      }
      return local;
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
        
    }

	
		
		
	
}
