package com.internal.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.internal.validations.EquinitiEmail;

import lombok.Data;

@Data
public class RegisterBean {

	@NumberFormat(style = Style.NUMBER)
	@NotNull
	@Min(1000)
	private int id;

	@Pattern(regexp = "[a-zA-Z]*", message = "First name should only have alphabets")
	@NotNull
	@NotEmpty
	private String firstName;

	@Pattern(regexp = "[a-zA-Z]*", message = "First name should only have alphabets")
	@NotNull
	@NotEmpty
	private String lastName;

	@Email
	@EquinitiEmail
	@NotNull
	@NotEmpty
	private String emailId;

	private String referenceRole;

	private String refernceTeam;

	private String vm;

	@NotNull
	@NotEmpty
	private String employeeProactive;

	@NotNull
	@NotEmpty
	private String employeeActive;

	@NotNull
	@NotEmpty
	private String password;

	@NotNull
	@NotEmpty(message = "confirmPassword must not be empty")
	private String confirmPassword;

}
