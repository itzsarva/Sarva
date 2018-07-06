package com.internal.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.internal.entity.EQLeaveType;
import com.internal.entity.EQTimeSheetDetails;

public interface TimeSheetDao {

	public String saveLeaves(List<EQTimeSheetDetails> timesheet);

	public List<EQLeaveType> getLeaveType(String description);

	public String getUserName(String name);

	public List<String> getRecordsFromDate(Date startDate, Date endDate, Long userId);

	public String isFirstLogin(String userName);

	public void updateFirstLogin(String userName);

	public void updatePassword(String password, String userName);

	public Map<String, List<String>> generateReport(Date startDate, Date endDate);

}
