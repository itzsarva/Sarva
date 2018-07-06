package com.internal.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.internal.customAnnotations.EquinitiEmail;

import lombok.Data;

@Data
public class RegisterBean {

	interface OnlyOnSave {

	}

	@NumberFormat(style = Style.NUMBER)
	@NotNull
	@Min(1000)
	private Long employeeId;

	@Pattern(regexp = "[a-zA-Z]*", message = "First name should only have alphabets")
	@NotNull
	@NotEmpty
	private String firstName;

	@Pattern(regexp = "[a-zA-Z]*", message = "Last name should only have alphabets")
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
	private String employeeProductive;

	private String isAdmin;

	@NotNull
	@NotEmpty
	private String employeeActive;

	@NotNull(groups = { OnlyOnSave.class })
	@NotEmpty(groups = { OnlyOnSave.class })
	private String password;

}
