package com.internal.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoginBean {

	@NotNull(message = "User Name cannot be null")
	@NotEmpty(message = "user name cannot be empty")
	private String empId;

	@NotNull(message = "password cannot be null")
	@NotEmpty(message = "password cannot be empty")
	private String password;

	@NotNull(message = "confirmPassword cannot be null")
	@NotEmpty(message = "confirmPassword cannot be empty")
	private String confirmPassword;

}
