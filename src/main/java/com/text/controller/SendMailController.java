package com.text.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.text.model.RequestMail;
import com.text.service.EmailServices;

@RestController
@CrossOrigin("*")
@RequestMapping("/mail")
public class SendMailController {

	@Autowired
private	EmailServices emailServices;
	@PostMapping("/sendmail")
	public ResponseEntity<String> sendmail(@RequestBody RequestMail requestMail) {
		String s="Get message from"+requestMail.getName();
		String m="<h4> Mobile Number :- </h4>"+requestMail.getPhone()+"<br><br>";
		m+=requestMail.getMessage();
		String to=requestMail.getEmail();
		emailServices.sendAttach(m, s, to);
		String msgString="success";
		return ResponseEntity.status(HttpStatus.CREATED).body(msgString);
	}
}
