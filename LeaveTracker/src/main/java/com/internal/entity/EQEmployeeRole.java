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
@Table(name = "EQ_EMPLOYEE_ROLE")
@NamedQueries({ @NamedQuery(name = "@HQL_GET_ALL_EMPLOYEEROLE", query = "from EQEmployeeRole") })
public class EQEmployeeRole {

	@TableGenerator(name = "Role_Gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Role_Gen", initialValue = 0)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Role_Gen")
	@Column(name = "ROLE_ID")
	private Long roleId;

	@Column(name = "DESCRIPTION")
	private String description;

	public EQEmployeeRole(String description) {
		this.description = description;
	}

	public EQEmployeeRole() {
	}
}
