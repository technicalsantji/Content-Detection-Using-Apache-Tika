package com.text.model;


import java.util.Arrays;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "image")

public class Image {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String i_id;

	private String name;

	private String type;

	@Lob
	private byte[] data;

	public Image(String i_id, String name, String type, byte[] data) {
		super();
		this.i_id = i_id;
		this.name = name;
		this.type = type;
		this.data = data;
	}

	public String getI_id() {
		return i_id;
	}

	public void setI_id(String i_id) {
		this.i_id = i_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Image [i_id=" + i_id + ", name=" + name + ", type=" + type + ", data=" + Arrays.toString(data) + "]";
	}

	public Image(String name, String type, byte[] data) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
	}

}