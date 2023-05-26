package com.text.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.text.model.FTRule;
import com.text.model.KWRule;
import com.text.model.PTRule;
import com.text.model.Template;
import com.text.repository.TemplateRepository;
@Service
public class FileWorkingServices {
	@Autowired
	private TemplateRepository templateRepository;
	
	public Template rulespatternkey(Long templateId) {
		
		Optional<Template> id = templateRepository.findById(templateId);
		Template template = id.get();
		
		
	
		
		
		return template;
		
		
	}

}
