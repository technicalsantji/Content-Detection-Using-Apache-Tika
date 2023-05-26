package com.text.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.text.model.Image;

public interface ImageRepository extends JpaRepository<Image, String>{
    
}
