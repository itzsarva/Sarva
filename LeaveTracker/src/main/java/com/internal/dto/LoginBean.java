package com.internal.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoginBean {

	@NotNull(message = "User Name cannot be null")
	@NotEmpty(message = "user name cannot be empty")
	private String empId;

	@NotNull(message = "User Name cannot be null")
	@NotEmpty(message = "user name cannot be empty")
	private String password;

}
