package com.text.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.text.model.fileOperations;

public interface FileOpRepository extends JpaRepository<fileOperations, Long> {

}
