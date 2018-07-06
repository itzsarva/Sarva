package com.internal.dto;

import lombok.Data;

@Data
public class DayBean {

	private String day;

	private String date;

	private String leaveType;

	@Override
	public String toString() {
		return "DayBean [day=" + day + ", date=" + date + ", leaveType=" + leaveType + "]";
	}

}
