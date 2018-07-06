package com.internal.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "EQ_USER_DETAILS")
@Data
public class AppUserDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "ROLE")
	private String role;
	@Column(name = "ENABLED")
	private int enabled;
	@Column(name = "FIRST_LOGIN")
	private String firstLogin;

}
