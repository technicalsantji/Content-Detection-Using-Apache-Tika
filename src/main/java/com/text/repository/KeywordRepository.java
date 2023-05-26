package com.text.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.text.model.KeywordTemplate;

public interface KeywordRepository extends JpaRepository<KeywordTemplate, Long> {
	
}
