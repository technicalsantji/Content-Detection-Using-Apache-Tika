package com.text.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.text.model.User;

public interface UserRepository extends JpaRepository<User,Long > {
    public User findByUsername(String username);
    public User findByUsernameAndPassword(String username, String password);
}