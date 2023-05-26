package com.text.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class PatternTemplate {
	@Id
//
//	@GeneratedValue(generator ="uuid")
//	@GenericGenerator(name = "uuid",strategy = "uuid2")

	@GeneratedValue(strategy =GenerationType.SEQUENCE)
	private Long p_Id;
	private String name;
	private String description;
	@ElementCollection(targetClass=String.class,fetch = FetchType.EAGER)
	private List<String> pattern;
	public Long getP_Id() {
		return p_Id;
	}
	public void setP_Id(Long p_Id) {
		this.p_Id = p_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getPattern() {
		return pattern;
	}
	public void setPattern(List<String> pattern) {
		this.pattern = pattern;
	}
	public PatternTemplate(Long p_Id, String name, String description, List<String> pattern) {
		super();
		this.p_Id = p_Id;
		this.name = name;
		this.description = description;
		this.pattern = pattern;
	}
	public PatternTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}