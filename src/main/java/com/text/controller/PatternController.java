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

import com.text.model.PatternTemplate;
import com.text.repository.PatternRepository;

@RestController
@CrossOrigin("*")
public class PatternController {
	@Autowired
	private PatternRepository patternRepository;
	@PostMapping("/patternsave")
	public ResponseEntity<PatternTemplate> savepattern(@RequestBody PatternTemplate patternTemplate) {
		PatternTemplate pTemplate = this.patternRepository.save(patternTemplate);
		return ResponseEntity.status(HttpStatus.CREATED).body(pTemplate);
	}
	@GetMapping("/getpattern")
	public ResponseEntity<List<PatternTemplate>> getallpattern(){
		List<PatternTemplate> findAll = this.patternRepository.findAll();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(findAll);
	}
	@GetMapping("/getpaternbyid/{id}")
	public ResponseEntity<PatternTemplate> getbyidpattern(@PathVariable Long id){
		Optional<PatternTemplate> opt = this.patternRepository.findById(id);
		PatternTemplate patternTemplate = opt.get();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(patternTemplate);
	}
	@DeleteMapping("/patterndelete/{id}")
	public ResponseEntity<String> deletepattern(@PathVariable("id") Long id){
		this.patternRepository.deleteById(id);
		String msg="delete success";
		return ResponseEntity.ok(msg);
	}
	@PutMapping("/updatepattren/{id}")
	
	public ResponseEntity<PatternTemplate> upadatepattern(@PathVariable("id") Long id,@RequestBody PatternTemplate patternTemplate){
		Optional<PatternTemplate> po = this.patternRepository.findById(id);
		PatternTemplate pattern = po.get();
		pattern.setName(patternTemplate.getName());
		pattern.setDescription(patternTemplate.getDescription());
		pattern.setPattern(patternTemplate.getPattern());
		
		PatternTemplate save = this.patternRepository.save(pattern);
		
	return	ResponseEntity.status(HttpStatus.ACCEPTED).body(save);
	}
	

}
