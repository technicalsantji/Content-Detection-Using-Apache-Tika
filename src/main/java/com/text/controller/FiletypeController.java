package com.text.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.text.model.FileExtDescriptionMaster;
import com.text.model.Filetypespattern;
import com.text.repository.FileExtDescriptionMasterRepository;
import com.text.repository.FiletypeRepository;

@RestController
@CrossOrigin("*")
public class FiletypeController {

	@Autowired
	private FiletypeRepository filetypeRepository;
	@Autowired
    private	FileExtDescriptionMasterRepository fileExtDescriptionMasterRepository;
	
	@GetMapping("/getallfile")
	public ResponseEntity<List<FileExtDescriptionMaster>> getallfiletype() {
		List<FileExtDescriptionMaster> findAll = this.fileExtDescriptionMasterRepository.findAll();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(findAll);
	}

	
	@PostMapping("/save-filetype")
	public ResponseEntity<Filetypespattern> savepattern(@RequestBody Filetypespattern filetypespattern) {
		
		Filetypespattern save = this.filetypeRepository.save(filetypespattern);
		return  ResponseEntity.status(HttpStatus.CREATED).body(save);
		 
	}
	@GetMapping("/getallfiletypes")
	public ResponseEntity<List<Filetypespattern>> getallfiletypes() {
		
		List<Filetypespattern> list = this.filetypeRepository.findAll();
		return ResponseEntity.ok(list);
		
	}
	@GetMapping("/filestype/{id}")
	public ResponseEntity<Filetypespattern> getfilebyid(@PathVariable("id") Long id) {
		
		Optional<Filetypespattern> findById = this.filetypeRepository.findById(id);
		Filetypespattern filetypespattern = findById.get();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(filetypespattern);
	}
	@DeleteMapping("/delete-filetype/{id}")
	public ResponseEntity<String> deletefilestype(@PathVariable("id") Long id) {
		this.filetypeRepository.deleteById(id);
		String msg="delete success";
		return ResponseEntity.ok(msg);
	}
	@PutMapping("/update-filetypes/{id}")
	public ResponseEntity<Filetypespattern> updatefiletype(@PathVariable("id") Long id,@RequestBody Filetypespattern filetypespattern){
		Optional<Filetypespattern> opt = this.filetypeRepository.findById(id);
		Filetypespattern filetypespattern2 = opt.get();
		filetypespattern2.setName(filetypespattern.getName());
		filetypespattern2.setDescriptions(filetypespattern.getDescriptions());
		filetypespattern2.setMonitor(filetypespattern.isMonitor());
		filetypespattern2.setFiletype(filetypespattern.getFiletype());
		
		Filetypespattern save = this.filetypeRepository.save(filetypespattern2);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(save);
	}
		
	
	
}
