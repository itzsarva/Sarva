package com.sarva.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class LookBussinessUnit {

	@Id
	@GeneratedValue
	private Long BUId;

	private String BUName;

	@OneToMany(mappedBy = "bUnit", cascade = CascadeType.ALL)
	private Set<EmployeeDetail> detail = new HashSet<EmployeeDetail>();

	@OneToMany(mappedBy = "bUnit", cascade = CascadeType.ALL)
	private Set<TeamProjectMapping> teamMapping = new HashSet<TeamProjectMapping>();

	public LookBussinessUnit() {

	}

	public LookBussinessUnit(Long bUId, String bUName) {
		super();
		BUId = bUId;
		BUName = bUName;
	}

	public Long getBUId() {
		return BUId;
	}

	public void setBUId(Long bUId) {
		BUId = bUId;
	}

	public String getBUName() {
		return BUName;
	}

	public void setBUName(String bUName) {
		BUName = bUName;
	}

	public Set<EmployeeDetail> getDetail() {
		return detail;
	}

	public void setDetail(Set<EmployeeDetail> detail) {
		this.detail = detail;
	}

	public Set<TeamProjectMapping> getTeamMapping() {
		return teamMapping;
	}

	public void setTeamMapping(Set<TeamProjectMapping> teamMapping) {
		this.teamMapping = teamMapping;
	}

}
