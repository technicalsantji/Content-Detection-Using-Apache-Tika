package com.text.model;

public class RequestMail {
	private String name;
	private String email;
	private String phone;
	private String message;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public RequestMail(String name, String email, String phone, String message) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.message = message;
	}
	public RequestMail() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RequestMail [name=" + name + ", email=" + email + ", phone=" + phone + ", message=" + message + "]";
	}
	

}
