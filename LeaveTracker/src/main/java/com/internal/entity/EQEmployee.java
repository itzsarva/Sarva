package com.internal.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Data;

@Entity
@Data
@Table(name = "EQ_EMPLOYEE_DETAILS")
@NamedQueries({ @NamedQuery(name = "@HQL_GET_ALL_EMPLOYEE", query = "from EQEmployee") })
public class EQEmployee {

	@Id
	@Column(name = "EMPLOYEE_ID")
	private Long employeeId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "ROLE_ID")
	private EQEmployeeRole referenceRole;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "TEAM_ID")
	private EQTeam refernceTeam;

	@OneToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "VM_ID")
	@NotFound(action = NotFoundAction.IGNORE)
	private EQVMDetails vm;

	@Column(name = "ISBILLABLE")
	private String employeeProductive;

	@Column(name = "EMPLOYEE_ACTIVE")
	private String employeeActive;

	@OneToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "USER_NAME")
	private AppUserDetails appDetails;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;
}
