package com.internal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class EQEmployee {

	@Id
	@GeneratedValue
	private long id;

	private String firstName;

	private String lastName;

	private String emailId;

	private String referenceRole;

	private String refernceTeam;

	private String vm;

	private String employeeProactive;

	private String employeeActive;

	private String password;

	private String confirmPassword;
}
