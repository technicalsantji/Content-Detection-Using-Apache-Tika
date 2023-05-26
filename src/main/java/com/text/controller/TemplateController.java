package com.text.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.engine.query.spi.EntityGraphQueryHint;
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

import com.text.model.Template;
import com.text.repository.TemplateRepository;

@RestController
@CrossOrigin("*")
public class TemplateController {
	
	@Autowired
	private TemplateRepository templateRepository;
	
	@PostMapping("/addtem")
	public ResponseEntity<Template> addtemplate(@RequestBody Template template) {
		Template save = this.templateRepository.save(template);
	return	ResponseEntity.status(HttpStatus.CREATED).body(save);
	}
	@GetMapping("/getalltem")
	public ResponseEntity<List<Template>> geTemplate() {
		List<Template> listtem = this.templateRepository.findAll();
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(listtem);
	}
	@GetMapping("/gettemplate/{id}")
	public ResponseEntity<Template> gettemplateById(@PathVariable("id") Long id) {
	
		Optional<Template> findById = this.templateRepository.findById(id);
		Template template = findById.get();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(template);
		
	}
	@DeleteMapping("/deletetem/{id}")
	public ResponseEntity<Long> deletetem(@PathVariable("id") Long id){
		this.templateRepository.deleteById(id);
		Long id1=id;
		return ResponseEntity.ok(id1);
	}
	@PutMapping("/updatetemplate/{id}")
	public ResponseEntity<Template> updatetemplate(@RequestBody Template template,@PathVariable("id") Long id){
		Optional<Template> fid =this.templateRepository.findById(id);
		Template template2 = fid.get();
		template2.setName(template.getName());
		template2.setDescription(template.getDescription());
	
		template2.setFiletyperules(template.getFiletyperules());
		template2.setKeywordrules(template.getKeywordrules());
		template2.setPatternrules(template.getPatternrules());
		Template save = this.templateRepository.save(template2);
	return ResponseEntity.status(HttpStatus.ACCEPTED).body(save);
	}
	
	
}
