package com.internal.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.internal.validations.EquinitiEmail;

public class RegisterBean {

	@NumberFormat(style = Style.NUMBER)
	@Size(min = 4, max = 10)
	private int id;

	@Pattern(regexp = "[a-zA-Z]*", message = "First name should only have alphabets")
	private String firstName;

	@Pattern(regexp = "[a-zA-Z]*", message = "First name should only have alphabets")
	private String lastname;

	@Email
	@EquinitiEmail
	private String emailId;

	private String referenceRole;

	private String refernceTeam;

	private String vm;

	private String employeeProactive;

	private String employeeActive;

	private String password;

	private String confirmPassword;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getReferenceRole() {
		return referenceRole;
	}

	public void setReferenceRole(String referenceRole) {
		this.referenceRole = referenceRole;
	}

	public String getRefernceTeam() {
		return refernceTeam;
	}

	public void setRefernceTeam(String refernceTeam) {
		this.refernceTeam = refernceTeam;
	}

	public String getVm() {
		return vm;
	}

	public void setVm(String vm) {
		this.vm = vm;
	}

	public String getEmployeeProactive() {
		return employeeProactive;
	}

	public void setEmployeeProactive(String employeeProactive) {
		this.employeeProactive = employeeProactive;
	}

	public String getEmployeeActive() {
		return employeeActive;
	}

	public void setEmployeeActive(String employeeActive) {
		this.employeeActive = employeeActive;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
