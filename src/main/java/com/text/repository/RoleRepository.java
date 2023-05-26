package com.text.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.text.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
