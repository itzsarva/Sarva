package com.internal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.Data;

@Entity
@Data
@Table(name = "EQ_EMPLOYEE_TEAM")
@NamedQueries({ @NamedQuery(name = "@HQL_GET_ALL_EQTEAM", query = "from EQTeam") })
public class EQTeam {

	@TableGenerator(name = "Team_Gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Team_Gen", initialValue = 0)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Team_Gen")
	@Column(name = "TEAM_ID")
	private Long teamId;

	@Column(name = "DESCRIPTION")
	private String description;

	public EQTeam(String description) {
		this.description = description;
	}

	public EQTeam() {
	}

}
