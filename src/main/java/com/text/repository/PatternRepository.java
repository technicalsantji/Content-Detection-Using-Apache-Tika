package com.text.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.text.model.PatternTemplate;

public interface PatternRepository extends JpaRepository<PatternTemplate, Long> {

}
