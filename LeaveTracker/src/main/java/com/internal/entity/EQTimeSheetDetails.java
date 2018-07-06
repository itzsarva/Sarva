package com.internal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "EQ_LEAVE_DETAILS")
public class EQTimeSheetDetails {

	@GeneratedValue
	private int id;

	@EmbeddedId
	private EmpTimeSheetPrimary empPrimary;

	@Column(name = "UPDATED_BY")
	private Long updatedBy;

	@Column(name = "UPDATED_ON")
	private Date updatedOn;

	@Column(name = "IS_FULLDAY")
	private String isfullDay;

	@ManyToOne
	@JoinColumn(name = "LEAVE_ID")
	private EQLeaveType leaveType;

}
