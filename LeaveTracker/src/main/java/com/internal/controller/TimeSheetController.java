package com.internal.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.internal.dto.EmployeeId;
import com.internal.dto.FindEmployee;
import com.internal.dto.GetUserDetails;
import com.internal.dto.TimeSheetBean;
import com.internal.serviceImpl.TimeSheetServiceImpl;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/viewtimeSheet")
@SessionAttributes({ "showLeaves", "getUserName" })
@Log4j2
public class TimeSheetController {

	public static int INCREMENT = 0;

	@Autowired
	TimeSheetServiceImpl service;

	@ModelAttribute("findEmp")
	public FindEmployee findEmployee() {
		return new FindEmployee();
	}

	@GetMapping
	public ModelAndView getLoginPage() {
		return new ModelAndView("viewtimeSheet");
	}

	@ModelAttribute("getUserName")
	public String getUserName(Principal principal) {
		System.err.println("coming Inside here  " + INCREMENT++);
		return principal.getName();
	}

	@GetMapping("homePage")
	public ModelAndView getHomePage(@ModelAttribute("getUserName") String userId) {
		ModelAndView modelAndView = new ModelAndView("viewtimeSheet");
		String userName = service.getUserName(userId);
		modelAndView.addObject("adminUserID", userId);
		modelAndView.addObject("adminUserName", userName);
		modelAndView.addObject("userID", userId);
		modelAndView.addObject("userName", userName);
		return log.traceExit("Leave Tracker Home Page has been successfully loaded", modelAndView);
	}

	@PostMapping("getUserNameAjax")
	public @ResponseBody String[] getAjaxResponseForNames(@RequestBody EmployeeId name) {
		String userName = service.getUserName(name.getId());
		System.err.println(userName);
		String[] values = { userName };
		return values;
	}

	@PostMapping("getLeavesAjax")
	public @ResponseBody List<String> getAjaxResponseForDates(@RequestBody GetUserDetails details,
			@ModelAttribute("getUserName") String userId) {
		System.err.println(details.getDates());
		System.err.println(details.getUser());
		System.err.println(userId);
		String empId = details.getUser();
		String startDate;
		String endDate = null;
		String[] startAndEndDate = details.getDates().split(",");
		startDate = startAndEndDate[0];
		System.err.println(startDate);
		if (startAndEndDate.length > 1) {
			endDate = startAndEndDate[1];
			System.err.println(endDate);
		}
		if (!(empId == null || empId.isEmpty())) {
			userId = empId;
		}
		List<String> dateResponse = service.getRecordsFromDate(startDate, endDate, userId);
		System.err.println(dateResponse);
		return dateResponse;
	}

	@ModelAttribute("showLeaves")
	public List<String> getLeaveTypes() {
		return service.getLeaveDes();
	}

	@ModelAttribute("leaveBean")
	public TimeSheetBean getTimeSheetBean() {
		return new TimeSheetBean();
	}

	@PostMapping("submitLeaveDetails")
	public void saveLeaveSheet(@ModelAttribute("leaveBean") TimeSheetBean bean, BindingResult result) {
		if (result.hasErrors()) {
			System.err.println(result.getErrorCount());
		}
		System.err.println(bean.toString());
		service.saveLeaves(bean);
	}

}
