package com.sarva.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sarva.annotation.NameValidator;

@Entity
public class Profile {

	@Id
	@GeneratedValue
	private int id;
	@NameValidator
	private String name;
	private String dOB;
	private String address;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "profie")
	@JsonManagedReference
	private List<Messages> mess = new ArrayList<Messages>();

	public List<Messages> getMess() {
		return mess;
	}

	public void setMess(List<Messages> mess) {
		this.mess = mess;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getdOB() {
		return dOB;
	}

	public void setdOB(String dOB) {
		this.dOB = dOB;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
