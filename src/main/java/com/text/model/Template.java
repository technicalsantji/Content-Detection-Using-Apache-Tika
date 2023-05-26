package com.text.model;

import java.util.Set;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Template {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tem_id;
	private String name;
	private String description;
	@OneToMany(cascade = CascadeType.ALL,fetch =FetchType.EAGER,mappedBy ="template")
	@JsonManagedReference
	private Set<PTRule> patternrules;
	@OneToMany(cascade = CascadeType.ALL,fetch =FetchType.EAGER,mappedBy ="template")
    @JsonManagedReference
	private Set<KWRule> keywordrules;
	@OneToMany(cascade = CascadeType.ALL,fetch =FetchType.EAGER,mappedBy ="template")
	@JsonManagedReference
	private Set<FTRule> filetyperules;
	public Long getTem_id() {
		return tem_id;
	}
	public void setTem_id(Long tem_id) {
		this.tem_id = tem_id;
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
	public Set<PTRule> getPatternrules() {
		return patternrules;
	}
	public void setPatternrules(Set<PTRule> patternrules) {
		this.patternrules = patternrules;
	}
	public Set<KWRule> getKeywordrules() {
		return keywordrules;
	}
	public void setKeywordrules(Set<KWRule> keywordrules) {
		this.keywordrules = keywordrules;
	}

	public Set<FTRule> getFiletyperules() {
		return filetyperules;
	}
	public void setFiletyperules(Set<FTRule> filetyperules) {
		this.filetyperules = filetyperules;
	}
	public Template(Long tem_id, String name, String description, Set<PTRule> patternrules, Set<KWRule> keywordrules,
			Set<FTRule> filetyperules) {
		super();
		this.tem_id = tem_id;
		this.name = name;
		this.description = description;
		this.patternrules = patternrules;
		this.keywordrules = keywordrules;
		this.filetyperules = filetyperules;
	}
	public Template() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Template(String name, String description, Set<PTRule> patternrules, Set<KWRule> keywordrules,
			Set<FTRule> filetyperules) {
		super();
		this.name = name;
		this.description = description;
		this.patternrules = patternrules;
		this.keywordrules = keywordrules;
		this.filetyperules = filetyperules;
	}
	@Override
	public String toString() {
		return "Template [tem_id=" + tem_id + ", name=" + name + ", description=" + description + ", patternrules="
				+ patternrules + ", keywordrules=" + keywordrules + ", filetyperules=" + filetyperules + "]";
	}


	

}
