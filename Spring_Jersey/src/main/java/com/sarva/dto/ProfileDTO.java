package com.sarva.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProfileDTO {

	private int id;
	private String name;
	private String dOB;
	private String address;
	// @JsonDeserialize(using = JsonDeserialization.class)
	private List<MessagesDTO> mess = new ArrayList<MessagesDTO>();

	public List<MessagesDTO> getMess() {
		return mess;
	}

	public void setMess(List<MessagesDTO> mess) {
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
