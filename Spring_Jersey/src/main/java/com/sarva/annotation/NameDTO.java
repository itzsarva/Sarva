package com.sarva.annotation;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class NameDTO {

	interface Forfew {

	}

	interface ForOtherFew {

	}

	public NameDTO() {

	}

	public NameDTO(String name, String age, String street, String pinCode) {
		super();
		this.name = name;
		this.age = age;
		this.street = street;
		this.pinCode = pinCode;
	}

	@NameValidator(groups = { Forfew.class })
	private String name;
	@NotEmpty(groups = { Forfew.class })
	private String age;
	@NotNull(groups = { ForOtherFew.class }, payload = { Severity.BigError.class })
	private String street;
	@NotNull(groups = { ForOtherFew.class })
	private String pinCode;

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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

}
