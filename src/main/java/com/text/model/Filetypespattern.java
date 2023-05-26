package com.text.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.*;

import org.hibernate.annotations.CollectionType;
@Entity
public class Filetypespattern {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long f_Id;
	private String name;
	private String descriptions;
	private boolean monitor;
	@ElementCollection(targetClass=String.class,fetch = FetchType.EAGER)
	private List<String> filetype;
	public Long getF_Id() {
		return f_Id;
	}
	public void setF_Id(Long f_Id) {
		this.f_Id = f_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public boolean isMonitor() {
		return monitor;
	}
	public void setMonitor(boolean monitor) {
		this.monitor = monitor;
	}
	public List<String> getFiletype() {
		return filetype;
	}
	public void setFiletype(List<String> filetype) {
		this.filetype = filetype;
	}
	public Filetypespattern() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Filetypespattern(Long f_Id, String name, String descriptions, boolean monitor, List<String> filetype) {
		super();
		this.f_Id = f_Id;
		this.name = name;
		this.descriptions = descriptions;
		this.monitor = monitor;
		this.filetype = filetype;
	}
	public Filetypespattern(String name, String descriptions, boolean monitor, List<String> filetype) {
		super();
		this.name = name;
		this.descriptions = descriptions;
		this.monitor = monitor;
		this.filetype = filetype;
	}
	@Override
	public String toString() {
		return "Filetypespattern [f_Id=" + f_Id + ", name=" + name + ", descriptions=" + descriptions + ", monitor="
				+ monitor + ", filetype=" + filetype + "]";
	}
	
	
	
	

}
