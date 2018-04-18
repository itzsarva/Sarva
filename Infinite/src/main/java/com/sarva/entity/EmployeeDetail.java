package com.sarva.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class EmployeeDetail {

	@Id
	private Long empId;

	@ManyToOne
	@JoinColumn(name = "BUId", nullable = false)
	private LookBussinessUnit bUnit;

	@OneToMany(mappedBy = "empDetail" , cascade = CascadeType.ALL)
	private Set<EmployeeProjectMapping> empMapping =  new HashSet<EmployeeProjectMapping>();

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

	public EmployeeDetail() {

	}

	public EmployeeDetail(Long empId, String emailId, String empName, Date dOJ, Date dOL, String project,
			String designation, String status, Long cTS, Long contactNumber, String classification, String isActive) {
		super();
		this.empId = empId;
		this.emailId = emailId;
		this.empName = empName;
		this.dOJ = dOJ;
		this.dOL = dOL;
		this.project = project;
		this.designation = designation;
		this.status = status;
		CTS = cTS;
		this.contactNumber = contactNumber;
		this.classification = classification;
		this.isActive = isActive;
	}

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

	public LookBussinessUnit getbUnit() {
		return bUnit;
	}

	public void setbUnit(LookBussinessUnit bUnit) {
		this.bUnit = bUnit;
	}

	public Set<EmployeeProjectMapping> getEmpMapping() {
		return empMapping;
	}

	public void setEmpMapping(Set<EmployeeProjectMapping> empMapping) {
		this.empMapping = empMapping;
	}

}
