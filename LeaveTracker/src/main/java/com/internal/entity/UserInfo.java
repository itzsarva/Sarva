package com.internal.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	private String role;
	@Column(name = "enabled")
	private int enabled;

	public UserInfo() {
		super();
	}

	public UserInfo(String userName, String password, String role, String fullName, String country, int enabled) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
	}

}
