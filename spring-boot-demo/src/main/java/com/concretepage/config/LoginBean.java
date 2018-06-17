package com.concretepage.config;

public class LoginBean {

	private String empId;

	private String password;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginBean [empId=" + empId + ", password=" + password + "]";
	}

}
