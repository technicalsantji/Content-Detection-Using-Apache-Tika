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
public class KWRule {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long k_id;
	private Long kt_id;
	private String kt_name;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonBackReference
	private Template template;
	public Long getK_id() {
		return k_id;
	}
	public void setK_id(Long k_id) {
		this.k_id = k_id;
	}
	public Long getKt_id() {
		return kt_id;
	}
	public void setKt_id(Long kt_id) {
		this.kt_id = kt_id;
	}
	public String getKt_name() {
		return kt_name;
	}
	public void setKt_name(String kt_name) {
		this.kt_name = kt_name;
	}
	public Template getTemplate() {
		return template;
	}
	public void setTemplate(Template template) {
		this.template = template;
	}
	public KWRule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KWRule(Long k_id, Long kt_id, String kt_name, Template template) {
		super();
		this.k_id = k_id;
		this.kt_id = kt_id;
		this.kt_name = kt_name;
		this.template = template;
	}
	
	
}
