package com.sarva.dto;

import java.util.Date;
import java.util.Set;

import com.sarva.entity.EmployeeProjectMapping;

public class TeamProjectMappingDTO {

	private Long teamProjectMappingId;

	private Set<EmployeeProjectMapping> empProjMapping;

	private LookBussinessUnitDTO bUnit;

	private String projectName;

	private String isCompleted;

	private Date createdDate;

	private String creationReason;

	private String createdUser;

	private Date modifiedDate;

	private String modifiedUser;

	private Long BUId;

	private String teamName;

	public Long getTeamProjectMappingId() {
		return teamProjectMappingId;
	}

	public void setTeamProjectMappingId(Long teamProjectMappingId) {
		this.teamProjectMappingId = teamProjectMappingId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(String isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreationReason() {
		return creationReason;
	}

	public void setCreationReason(String creationReason) {
		this.creationReason = creationReason;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public Long getBUId() {
		return BUId;
	}

	public void setBUId(Long bUId) {
		BUId = bUId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Set<EmployeeProjectMapping> getEmpProjMapping() {
		return empProjMapping;
	}

	public void setEmpProjMapping(Set<EmployeeProjectMapping> empProjMapping) {
		this.empProjMapping = empProjMapping;
	}

	public LookBussinessUnitDTO getbUnit() {
		return bUnit;
	}

	public void setbUnit(LookBussinessUnitDTO bUnit) {
		this.bUnit = bUnit;
	}

}
