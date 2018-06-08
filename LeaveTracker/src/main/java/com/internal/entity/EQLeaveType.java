package com.internal.entity;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class EQLeaveType {

	private long id;

	private String leaveDescription;

}
