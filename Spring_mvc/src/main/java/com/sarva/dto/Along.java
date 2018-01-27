package com.sarva.dto;

import org.hibernate.validator.constraints.NotEmpty;

import com.sarva.custAnnotation.Sarva;

public class Along {

	@NotEmpty
	@Sarva
	private String name;
	private String age;
	private String kiss;

	public String getKiss() {
		return kiss;
	}

	public void setKiss(String kiss) {
		this.kiss = kiss;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
