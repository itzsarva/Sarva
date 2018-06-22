package com.internal.serviceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.internal.dao.TimeSheetDao;
import com.internal.dto.TimeSheetBean;
import com.internal.entity.EQLeaveType;
import com.internal.entity.EQTimeSheetDetails;
import com.internal.entity.EmpTimeSheetPrimary;
import com.microsoft.sqlserver.jdbc.StringUtils;

@Service
@Transactional
public class TimeSheetServiceImpl {

	@Autowired
	TimeSheetDao timeSheetDao;

	@Transactional(isolation = Isolation.REPEATABLE_READ)
	public String getUserName(String Id) {
		return timeSheetDao.getUserName(Id);
	}

	public String saveLeaves(TimeSheetBean bean) {
		List<EQTimeSheetDetails> sumbitLeaves = new ArrayList<>();
		if (null != bean.getDateDay1() && !bean.getDateDay1().isEmpty()) {
			EQTimeSheetDetails day1 = populateEntityFromDao(bean.getDateDay1(), bean.getLeaveDay1(),
					bean.getSubmitter(), bean.getUser());
			sumbitLeaves.add(day1);
		}
		if (null != bean.getDateDay2() && !bean.getDateDay2().isEmpty()) {
			EQTimeSheetDetails day2 = populateEntityFromDao(bean.getDateDay2(), bean.getLeaveDay2(),
					bean.getSubmitter(), bean.getUser());
			sumbitLeaves.add(day2);
		}
		if (null != bean.getDateDay3() && !bean.getDateDay3().isEmpty()) {
			EQTimeSheetDetails day3 = populateEntityFromDao(bean.getDateDay3(), bean.getLeaveDay3(),
					bean.getSubmitter(), bean.getUser());
			sumbitLeaves.add(day3);
		}
		if (null != bean.getDateDay4() && !bean.getDateDay4().isEmpty()) {
			EQTimeSheetDetails day4 = populateEntityFromDao(bean.getDateDay4(), bean.getLeaveDay4(),
					bean.getSubmitter(), bean.getUser());
			sumbitLeaves.add(day4);
		}

		if (null != bean.getDateDay5() && !bean.getDateDay5().isEmpty()) {
			EQTimeSheetDetails day5 = populateEntityFromDao(bean.getDateDay5(), bean.getLeaveDay5(),
					bean.getSubmitter(), bean.getUser());
			sumbitLeaves.add(day5);
		}
		timeSheetDao.saveLeaves(sumbitLeaves);
		return "success";
	}

	public List<String> getLeaveDes() {
		List<EQLeaveType> leaves = timeSheetDao.getLeaveType(null);
		return leaves.stream().map(a -> a.getDescription()).collect(Collectors.toList());
	}

	public EQTimeSheetDetails populateEntityFromDao(String date, String leave, String submitter, String user) {
		String errorMessage = StringUtils.EMPTY;
		EQTimeSheetDetails day = new EQTimeSheetDetails();
		Optional<EQLeaveType> leaveType = timeSheetDao.getLeaveType(leave).stream().findFirst();
		day.setLeaveType(leaveType.get());
		if (leave.equalsIgnoreCase("Present Full Day")) {
			day.setIsfullDay("NA");
		} else if (!(leave.equalsIgnoreCase("Permission -1") || leave.equalsIgnoreCase("Permission -2"))) {
			day.setIsfullDay("Y");
		} else if (leave.equalsIgnoreCase("Permission -1")) {
			day.setIsfullDay("N - 1");
		} else {
			day.setIsfullDay("N - 2");
		}
		EmpTimeSheetPrimary empPrimary = new EmpTimeSheetPrimary();
		try {
			DateFormat format = new SimpleDateFormat("mm/dd/yyyy");
			empPrimary.setAttendanceDate(format.parse(date));
		} catch (ParseException e) {
			errorMessage = "ParseException";
		}
		empPrimary.setEmployeeId(new Long(user));
		day.setEmpPrimary(empPrimary);
		day.setUpdatedBy(new Long(submitter));
		day.setUpdatedOn(Calendar.getInstance().getTime());
		System.err.println(errorMessage);
		return day;
	}

	public List<String> getRecordsFromDate(String startDay, String endDay, String userId) {
		Date startDate = null;
		Date endDate = null;
		Long userIdl = new Long(userId);
		try {
			DateFormat format = new SimpleDateFormat("mm/dd/yyyy");
			startDate = format.parse(startDay);
			System.err.println(startDate);
			if (null != endDay) {
				endDate = format.parse(endDay);
			}
			System.err.println(endDate);
		} catch (ParseException e) {
			System.err.println("Error Message");
		}
		return timeSheetDao.getRecordsFromDate(startDate, endDate, userIdl);
	}

}
