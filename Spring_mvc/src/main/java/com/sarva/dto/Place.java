package com.sarva.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.sarva.custAnnotation.Sarva;

public class Place {

	@Size(min = 3, max = 15)
	@Sarva
	private String where;
	@NotEmpty()
	private String why;
	private String custom;
	private Date when;
	private List<String> things = new ArrayList<>();
	private Along along;

	public Along getAlong() {
		return along;
	}

	public void setAlong(Along along) {
		this.along = along;
	}

	public Date getWhen() {
		return when;
	}

	public void setWhen(Date when) {
		this.when = when;
	}

	public List<String> getThings() {
		return things;
	}

	public void setThings(List<String> things) {
		this.things = things;
	}

	public String getCustom() {
		return custom;
	}

	public void setCustom(String custom) {
		this.custom = custom;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public String getWhy() {
		return why;
	}

	public void setWhy(String why) {
		this.why = why;
	}

}
