package com.text.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.text.model.Role;
import com.text.model.User;
import com.text.model.UserRole;
import com.text.service.UserService;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    
    @Autowired 
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @PostMapping("/")
    public User craeteUser(@RequestBody User user) throws Exception {
        user.setProfile("default.png");
        Set<UserRole> roles=new HashSet<>();

        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        
        
        Role role=new Role();
        role.setRoleid(101L);
        role.setRolename("NORMAL");

        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);
        final User user1 = this.userService.createUser(user, roles);
        return user1;
    }
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        final User user = this.userService.getUser(username);
        return user;

    }

}
