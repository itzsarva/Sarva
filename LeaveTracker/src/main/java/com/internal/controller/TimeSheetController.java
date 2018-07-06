package com.internal.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
import com.internal.dto.LoginBean;
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

	@Autowired
	@Qualifier("firstLoginValidator")
	private Validator passwordValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		if (binder.getObjectName().equalsIgnoreCase("loginBean"))
			binder.addValidators(passwordValidator);
	}

	@GetMapping
	public ModelAndView getLoginPage() {
		return new ModelAndView("viewtimeSheet");
	}

	@ModelAttribute("getUserName")
	public String getUserName(Principal principal) {
		return principal.getName();
	}

	@ModelAttribute("loginBean")
	public LoginBean loginBean() {
		return new LoginBean();
	}

	@GetMapping("checkFirstLogin")
	public ModelAndView checkFirstLogin(@ModelAttribute("getUserName") String userId) {
		String isFirstLogin = service.fingFirstLogin(userId);
		if (isFirstLogin.equalsIgnoreCase("Y")) {
			ModelAndView firstLogin = new ModelAndView("first_login");
			LoginBean loginBean = new LoginBean();
			loginBean.setEmpId(userId);
			firstLogin.addObject("loginBean", loginBean);
			return firstLogin;
		} else {
			return getHomePage(userId);
		}
	}

	@PostMapping("savePasswordDetails")
	public ModelAndView savePasswordDetails(@ModelAttribute("loginBean") @Valid LoginBean loginBean,
			BindingResult savePasswordErrors, @ModelAttribute("getUserName") String userId) {
		if (savePasswordErrors.hasErrors()) {
			ModelAndView firstLogin = new ModelAndView("first_login");
			firstLogin.addObject("loginBean", loginBean);
			return firstLogin;
		} else {
			if (INCREMENT == 0) {
				service.updateFirstLogin(userId);
				service.updatePassword(loginBean, userId);
			}
			INCREMENT++;
			return getHomePage(userId);
		}
	}

	@GetMapping("homePage")
	public ModelAndView getHomePage(@ModelAttribute("getUserName") String userId) {
		ModelAndView modelAndView = new ModelAndView("viewtimeSheet");
		FindEmployee emp = new FindEmployee();
		String userName = service.getUserName(userId);
		modelAndView.addObject("adminUserID", userId);
		modelAndView.addObject("adminUserName", userName);
		modelAndView.addObject("userID", userId);
		modelAndView.addObject("userName", userName);
		modelAndView.addObject("findEmp", emp);
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
	public @ResponseBody String saveLeaveSheet(@ModelAttribute("leaveBean") TimeSheetBean bean, BindingResult result) {
		if (result.hasErrors()) {
			System.err.println(result.getErrorCount());
			return "failure";
		}
		System.err.println(bean.toString());
		service.saveLeaves(bean);
		return "success";
	}

}
