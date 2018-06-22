package com.internal.entity;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class EQTimeSheetDetails {

	@GeneratedValue
	private int id;

	@EmbeddedId
	private EmpTimeSheetPrimary empPrimary;

	private long updatedBy;

	private Date updatedOn;

	private String isfullDay;

	@ManyToOne
	@JoinColumn(name = "LEAVE_ID")
	private EQLeaveType leaveType;

}
