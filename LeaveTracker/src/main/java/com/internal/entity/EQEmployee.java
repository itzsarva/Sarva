package com.internal.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Data;

@Entity
@Data
@NamedQueries({ @NamedQuery(name = "@HQL_GET_ALL_EMPLOYEE", query = "from EQEmployee") })
public class EQEmployee {

	@Id
	private long Employeeid;

	@GeneratedValue
	private int serialNumber;

	private String firstName;

	private String lastName;

	private String emailId;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "ROLE_ID")
	private EQEmployeeRole referenceRole;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "TEAM_ID")
	private EQTeam refernceTeam;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "VM_ID")
	private EQVMDetails vm;

	private String employeeProactive;

	private String employeeActive;

	private String password;

	private Date createdDate;

	private Date updatedDate;
}
