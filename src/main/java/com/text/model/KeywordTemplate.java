package com.text.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class KeywordTemplate {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long k_Id;
	private String name;
	private String description;
	@ElementCollection(targetClass=String.class,fetch = FetchType.EAGER)
	private List<String> keyword;
	public long getK_Id() {
		return k_Id;
	}
	public void setK_Id(long k_Id) {
		this.k_Id = k_Id;
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
	public List<String> getKeyword() {
		return keyword;
	}
	public void setKeyword(List<String> keyword) {
		this.keyword = keyword;
	}
	public KeywordTemplate(long k_Id, String name, String description, List<String> keyword) {
		super();
		this.k_Id = k_Id;
		this.name = name;
		this.description = description;
		this.keyword = keyword;
	}
	public KeywordTemplate(String name, String description, List<String> keyword) {
		super();
		this.name = name;
		this.description = description;
		this.keyword = keyword;
	}
	public KeywordTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "KeywordTemplate [k_Id=" + k_Id + ", name=" + name + ", description=" + description + ", keyword="
				+ keyword + "]";
	}
	
	
	
	
	
}
