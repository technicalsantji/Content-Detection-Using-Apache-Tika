package com.text.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drew.imaging.FileType;
import com.text.model.Filetypespattern;

public interface FiletypeRepository extends JpaRepository<Filetypespattern, Long>{

}
