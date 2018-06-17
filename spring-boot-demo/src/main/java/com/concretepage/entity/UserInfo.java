package com.concretepage.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	private String role;
	@Column(name = "full_name")
	private String fullName;
	@Column(name = "country")
	private String country;
	@Column(name = "enabled")
	private short enabled;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public short getEnabled() {
		return enabled;
	}

	public void setEnabled(short enabled) {
		this.enabled = enabled;
	}

	public UserInfo(String userName, String password, String role, String fullName, String country, short enabled) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.fullName = fullName;
		this.country = country;
		this.enabled = enabled;
	}

	public UserInfo() {
		super();
	}

	@Override
	public String toString() {
		return "UserInfo [userName=" + userName + ", password=" + password + ", role=" + role + ", fullName=" + fullName
				+ ", country=" + country + ", enabled=" + enabled + "]";
	}

}
