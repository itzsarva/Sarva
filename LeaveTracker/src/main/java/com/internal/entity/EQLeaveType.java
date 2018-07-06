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
@Table(name = "EQ__LEAVE_TYPE")
@NamedQueries({ @NamedQuery(name = "@HQL_GET_ALL_EMPLOYE_LEAVETYPE", query = "from EQLeaveType") })
public class EQLeaveType {

	@TableGenerator(name = "Leave_Gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Leave_Gen", initialValue = 0)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Leave_Gen")
	@Column(name = "LEAVE_ID")
	private Long leaveid;

	@Column(name = "DESCRIPTION")
	private String description;

	public EQLeaveType(String description) {
		this.description = description;
	}

	public EQLeaveType() {
	}

}
