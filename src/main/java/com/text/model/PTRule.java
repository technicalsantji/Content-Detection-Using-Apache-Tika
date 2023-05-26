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
public class PTRule {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long p_id;
	private Long pt_id;
	private String pt_name;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonBackReference
	private Template template;
	public Long getP_id() {
		return p_id;
	}
	public void setP_id(Long p_id) {
		this.p_id = p_id;
	}
	public Long getPt_id() {
		return pt_id;
	}
	public void setPt_id(Long pt_id) {
		this.pt_id = pt_id;
	}
	public String getPt_name() {
		return pt_name;
	}
	public void setPt_name(String pt_name) {
		this.pt_name = pt_name;
	}
	public Template getTemplate() {
		return template;
	}
	public void setTemplate(Template template) {
		this.template = template;
	}
	public PTRule(Long p_id, Long pt_id, String pt_name, Template template) {
		super();
		this.p_id = p_id;
		this.pt_id = pt_id;
		this.pt_name = pt_name;
		this.template = template;
	}
	public PTRule() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
