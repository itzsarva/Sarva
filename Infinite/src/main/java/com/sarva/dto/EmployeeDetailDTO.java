package com.sarva.dto;

import java.util.Date;
import java.util.Set;

import com.sarva.entity.EmployeeProjectMapping;

public class EmployeeDetailDTO {

	private Long empId;

	private LookBussinessUnitDTO bUnit;

	private Set<EmployeeProjectMapping> empMapping;

	private String emailId;

	private String empName;

	private Date dOJ;

	private Date dOL;

	private String project;

	private String designation;

	private String status;

	private Long CTS;

	private Long contactNumber;

	private String classification;

	private String isActive;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getdOJ() {
		return dOJ;
	}

	public void setdOJ(Date dOJ) {
		this.dOJ = dOJ;
	}

	public Date getdOL() {
		return dOL;
	}

	public void setdOL(Date dOL) {
		this.dOL = dOL;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCTS() {
		return CTS;
	}

	public void setCTS(Long cTS) {
		CTS = cTS;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public LookBussinessUnitDTO getbUnit() {
		return bUnit;
	}

	public void setbUnit(LookBussinessUnitDTO bUnit) {
		this.bUnit = bUnit;
	}

	public Set<EmployeeProjectMapping> getEmpMapping() {
		return empMapping;
	}

	public void setEmpMapping(Set<EmployeeProjectMapping> empMapping) {
		this.empMapping = empMapping;
	}

}
