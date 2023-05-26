package com.text.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class FileExtDescriptionMaster {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int fileextdescriptionmasterid;
	private String extensions;
	private String description;
	public int getFileextdescriptionmasterid() {
		return fileextdescriptionmasterid;
	}
	public void setFileextdescriptionmasterid(int fileextdescriptionmasterid) {
		this.fileextdescriptionmasterid = fileextdescriptionmasterid;
	}
	public String getExtensions() {
		return extensions;
	}
	public void setExtensions(String extensions) {
		this.extensions = extensions;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public FileExtDescriptionMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileExtDescriptionMaster(int fileextdescriptionmasterid, String extensions, String description) {
		super();
		this.fileextdescriptionmasterid = fileextdescriptionmasterid;
		this.extensions = extensions;
		this.description = description;
	}
	
	
}
