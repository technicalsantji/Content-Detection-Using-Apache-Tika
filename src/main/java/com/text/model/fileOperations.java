package com.text.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class fileOperations {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long file_id;
	private Long temId;
	private String filename;
	private String processingstate;
	
	
	public String getProcessingstate() {
		return processingstate;
	}
	public void setProcessingstate(String processingstate) {
		this.processingstate = processingstate;
	}
	public Long getFile_id() {
		return file_id;
	}
	public void setFile_id(Long file_id) {
		this.file_id = file_id;
	}
	public Long getTemId() {
		return temId;
	}
	public void setTemId(Long temId) {
		this.temId = temId;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public fileOperations(Long file_id, Long temId, String filename) {
		super();
		this.file_id = file_id;
		this.temId = temId;
		this.filename = filename;
	}
	public fileOperations() {
		super();
		// TODO Auto-generated constructor stub
	}
	public fileOperations(Long temId, String filename) {
		super();
		this.temId = temId;
		this.filename = filename;
	}
	public fileOperations(Long file_id, Long temId, String filename, String processingstate) {
		super();
		this.file_id = file_id;
		this.temId = temId;
		this.filename = filename;
		this.processingstate = processingstate;
	}
	public fileOperations(Long temId, String filename, String processingstate) {
		super();
		this.temId = temId;
		this.filename = filename;
		this.processingstate = processingstate;
	}
	
	
	

}
