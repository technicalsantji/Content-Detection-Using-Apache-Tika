package com.text.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class FTRule {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long f_id;
	private Long ft_id;
	private String ft_name;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonBackReference
	private Template template;
	public Long getF_id() {
		return f_id;
	}
	public void setF_id(Long f_id) {
		this.f_id = f_id;
	}
	public Long getFt_id() {
		return ft_id;
	}
	public void setFt_id(Long ft_id) {
		this.ft_id = ft_id;
	}
	public String getFt_name() {
		return ft_name;
	}
	public void setFt_name(String ft_name) {
		this.ft_name = ft_name;
	}
	public Template getTemplate() {
		return template;
	}
	public void setTemplate(Template template) {
		this.template = template;
	}
	public FTRule(Long f_id, Long ft_id, String ft_name, Template template) {
		super();
		this.f_id = f_id;
		this.ft_id = ft_id;
		this.ft_name = ft_name;
		this.template = template;
	}
	public FTRule() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
