package com.text.service;

import java.util.Set;

import com.text.model.User;
import com.text.model.UserRole;

public interface UserService {
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    public User getUser(String username);
   
}