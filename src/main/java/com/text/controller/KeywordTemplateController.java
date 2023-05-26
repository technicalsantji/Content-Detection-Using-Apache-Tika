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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.text.model.KeywordTemplate;
import com.text.repository.KeywordRepository;

@CrossOrigin("*")
@RestController
public class KeywordTemplateController {
	
	@Autowired
private	KeywordRepository keywordRepository;
	
	@PostMapping("/keytemplate")
	public ResponseEntity<KeywordTemplate> handkey(@RequestBody KeywordTemplate keywordTemplate) {
		
		String name = keywordTemplate.getName();
		String description = keywordTemplate.getDescription();
		List<String> keyword = keywordTemplate.getKeyword();
		
		KeywordTemplate save = keywordRepository.save(keywordTemplate);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);
		
	}
	
	@GetMapping("/getkey")
	public ResponseEntity<List<KeywordTemplate>> getkeytemplate() {
		
		List<KeywordTemplate> findAll = this.keywordRepository.findAll();
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(findAll);
		
	}
	@GetMapping("/getbytem/{id}")
	public ResponseEntity<Optional<KeywordTemplate>> getbykeytem(@PathVariable("id") Long id) {
		 Optional<KeywordTemplate> tem = this.keywordRepository.findById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(tem);
	}
	@DeleteMapping("/keydelete/{id}")
	public ResponseEntity<String> keydelete(@PathVariable("id") Long id) {
		this.keywordRepository.deleteById(id);
		String msgString="success from databases";
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(msgString);
	}
	
	@PutMapping("/updatekey/{id}")
	public ResponseEntity<KeywordTemplate> updatekey(@PathVariable("id") Long id,@RequestBody KeywordTemplate keywordTemplate){
		Optional<KeywordTemplate> tem = this.keywordRepository.findById(id);
		KeywordTemplate keywordTemplate2 = tem.get();
		keywordTemplate2.setName(keywordTemplate.getName());
		keywordTemplate2.setDescription(keywordTemplate.getDescription());
		keywordTemplate2.setKeyword(keywordTemplate.getKeyword());
		
		KeywordTemplate save = this.keywordRepository.save(keywordTemplate2);
		System.out.println(keywordTemplate2);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(save);
		
		
	}

}
