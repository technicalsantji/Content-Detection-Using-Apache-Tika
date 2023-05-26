package com.text.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;
@Entity
public class Filetypeextlibmap {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int filetypeextlibmapid;
	private String extensions;
	private String detectedcontenttype;
	private int processinglib;
	private boolean ispwdprotectiondetectable;
	
	
	public Filetypeextlibmap(int filetypeextlibmapid, String extensions, String detectedcontenttype, int processinglib,
			boolean ispwdprotectiondetectable) {
		super();
		this.filetypeextlibmapid = filetypeextlibmapid;
		this.extensions = extensions;
		this.detectedcontenttype = detectedcontenttype;
		this.processinglib = processinglib;
		this.ispwdprotectiondetectable = ispwdprotectiondetectable;
	}


	public int getFiletypeextlibmapid() {
		return filetypeextlibmapid;
	}


	public void setFiletypeextlibmapid(int filetypeextlibmapid) {
		this.filetypeextlibmapid = filetypeextlibmapid;
	}


	public String getExtensions() {
		return extensions;
	}


	public void setExtensions(String extensions) {
		this.extensions = extensions;
	}


	public String getDetectedcontenttype() {
		return detectedcontenttype;
	}


	public void setDetectedcontenttype(String detectedcontenttype) {
		this.detectedcontenttype = detectedcontenttype;
	}


	public int getProcessinglib() {
		return processinglib;
	}


	public void setProcessinglib(int processinglib) {
		this.processinglib = processinglib;
	}


	public boolean isIspwdprotectiondetectable() {
		return ispwdprotectiondetectable;
	}


	public void setIspwdprotectiondetectable(boolean ispwdprotectiondetectable) {
		this.ispwdprotectiondetectable = ispwdprotectiondetectable;
	}


	public Filetypeextlibmap() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
