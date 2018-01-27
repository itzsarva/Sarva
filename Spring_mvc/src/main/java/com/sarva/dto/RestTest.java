package com.sarva.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonPropertyOrder({ "attOne" })
@JsonIgnoreProperties({ "attThree" })
@JsonRootName(value = "RestTest")
public class RestTest {

	@JsonProperty("changedName")
	private String attOne;
	private String attTwo;
	private String attThree;

	public String getAttOne() {
		return attOne;
	}

	public void setAttOne(String attOne) {
		this.attOne = attOne;
	}

	public String getAttTwo() {
		return attTwo;
	}

	public void setAttTwo(String attTwo) {
		this.attTwo = attTwo;
	}

	public String getAttThree() {
		return attThree;
	}

	public void setAttThree(String attThree) {
		this.attThree = attThree;
	}

}
