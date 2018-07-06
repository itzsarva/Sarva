package com.internal.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class EmpTimeSheetPrimary implements Serializable {

	private static final long serialVersionUID = -5116685773394686396L;

	private Long employeeId;

	private Date attendanceDate;

}
