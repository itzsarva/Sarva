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
public class TeamProjectMapping {

	@Id
	private Long teamProjectMappingId;

	@OneToMany(mappedBy = "teamProjMapping", cascade = CascadeType.ALL)
	private Set<EmployeeProjectMapping> empProjMapping = new HashSet<EmployeeProjectMapping>();

	@ManyToOne()
	@JoinColumn(name = "BUId", nullable = false)
	private LookBussinessUnit bUnit;

	private String projectName;

	private String isCompleted;

	private Date createdDate;

	private String creationReason;

	private String createdUser;

	private Date modifiedDate;

	private String modifiedUser;

	private String teamName;

	public TeamProjectMapping() {

	}

	public TeamProjectMapping(Long teamProjectMappingId, String projectName, String isCompleted, Date createdDate,
			String creationReason, String createdUser, Date modifiedDate, String modifiedUser, String teamName) {
		super();
		this.teamProjectMappingId = teamProjectMappingId;
		this.projectName = projectName;
		this.isCompleted = isCompleted;
		this.createdDate = createdDate;
		this.creationReason = creationReason;
		this.createdUser = createdUser;
		this.modifiedDate = modifiedDate;
		this.modifiedUser = modifiedUser;
		this.teamName = teamName;
	}

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

	public LookBussinessUnit getbUnit() {
		return bUnit;
	}

	public void setbUnit(LookBussinessUnit bUnit) {
		this.bUnit = bUnit;
	}

}
