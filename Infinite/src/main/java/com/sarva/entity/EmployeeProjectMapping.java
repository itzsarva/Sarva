package com.sarva.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EmployeeProjectMapping {

	@Id
	private Long employeeProjectMapping;

	@ManyToOne
	@JoinColumn(name = "empId")
	private EmployeeDetail empDetail;

	@ManyToOne
	@JoinColumn(name = "teamProjectMappingId")
	private TeamProjectMapping teamProjMapping;

	private String createdUser;

	private Date createdDate;

	private String modifiedUser;

	private Date modifiedDate;
	
	public EmployeeProjectMapping(){
		
	}

	public EmployeeProjectMapping(Long employeeProjectMapping, String createdUser, Date createdDate, String modifiedUser,
			Date modifiedDate) {
		super();
		this.employeeProjectMapping = employeeProjectMapping;
		this.createdUser = createdUser;
		this.createdDate = createdDate;
		this.modifiedUser = modifiedUser;
		this.modifiedDate = modifiedDate;
	}

	public Long getEmployeeProjectMapping() {
		return employeeProjectMapping;
	}

	public void setEmployeeProjectMapping(Long employeeProjectMapping) {
		this.employeeProjectMapping = employeeProjectMapping;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public EmployeeDetail getEmpDetail() {
		return empDetail;
	}

	public void setEmpDetail(EmployeeDetail empDetail) {
		this.empDetail = empDetail;
	}

	public TeamProjectMapping getTeamProjMapping() {
		return teamProjMapping;
	}

	public void setTeamProjMapping(TeamProjectMapping teamProjMapping) {
		this.teamProjMapping = teamProjMapping;
	}

}
