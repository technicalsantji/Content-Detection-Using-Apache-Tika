package com.text.model;

public class ResponseFile {
	  private String rf_id;
	  private String name;
	  private String url;
	  private String type;
	  private long size;
	  
	  
	public String getRf_id() {
		return rf_id;
	}
	public void setRf_id(String rf_id) {
		this.rf_id = rf_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public ResponseFile(String rf_id, String name, String url, String type, long size) {
		super();
		this.rf_id = rf_id;
		this.name = name;
		this.url = url;
		this.type = type;
		this.size = size;
	}
	public ResponseFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
	  

}