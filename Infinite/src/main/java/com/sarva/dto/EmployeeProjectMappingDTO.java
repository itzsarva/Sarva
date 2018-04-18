package com.sarva.dto;

import java.util.Date;

public class EmployeeProjectMappingDTO {

	private Long employeeProjectMapping;

	private EmployeeDetailDTO empDetail;

	private TeamProjectMappingDTO teamProjMapping;

	private String createdUser;

	private Date createdDate;

	private String modifiedUser;

	private Date modifiedDate;

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

	public EmployeeDetailDTO getEmpDetail() {
		return empDetail;
	}

	public void setEmpDetail(EmployeeDetailDTO empDetail) {
		this.empDetail = empDetail;
	}

	public TeamProjectMappingDTO getTeamProjMapping() {
		return teamProjMapping;
	}

	public void setTeamProjMapping(TeamProjectMappingDTO teamProjMapping) {
		this.teamProjMapping = teamProjMapping;
	}

}
