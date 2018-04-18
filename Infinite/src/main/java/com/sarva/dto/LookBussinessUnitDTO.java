package com.sarva.dto;

import java.util.Set;

public class LookBussinessUnitDTO {

	private Long BUId;

	private String BUName;

	private Set<EmployeeDetailDTO> detail;

	private Set<TeamProjectMappingDTO> teamMapping;

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

	public Set<EmployeeDetailDTO> getDetail() {
		return detail;
	}

	public void setDetail(Set<EmployeeDetailDTO> detail) {
		this.detail = detail;
	}

	public Set<TeamProjectMappingDTO> getTeamMapping() {
		return teamMapping;
	}

	public void setTeamMapping(Set<TeamProjectMappingDTO> teamMapping) {
		this.teamMapping = teamMapping;
	}

}
