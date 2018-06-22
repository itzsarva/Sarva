package com.internal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.internal.dto.FindEmployee;
import com.internal.dto.RegisterBean;
import com.internal.serviceImpl.RegisterServiceImpl;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	RegisterServiceImpl service;

	@Autowired
	@Qualifier("passwordValidator")
	private Validator passwordValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		if (!binder.getObjectName().equalsIgnoreCase("findEmp"))
			binder.addValidators(passwordValidator);
	}

	@ModelAttribute("getRoles")
	public List<String> getRoles() {
		return service.getRoles();
	}

	@ModelAttribute("referenceTeam")
	public List<String> getReferenceTeam() {
		return service.getTeam();
	}

	@ModelAttribute("getVm")
	public List<String> getvm() {
		return service.getVM();
	}

	@RequestMapping(value = "/showForm", params = "action=add", method = RequestMethod.POST)
	public ModelAndView showFormAdd(@ModelAttribute("findEmp") FindEmployee emp) {
		ModelAndView modelAndView = new ModelAndView("newEmployee");
		RegisterBean bean = new RegisterBean();
		bean.setEmployeeid(emp.getEmployeeId());
		modelAndView.addObject("registerBean", bean);
		return modelAndView;
	}

	@RequestMapping(value = "/showForm", params = "action=edit", method = RequestMethod.POST)
	public ModelAndView showFormEdit(@ModelAttribute("findEmp") @Valid FindEmployee emp, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("EmployeeNotFound");
		}
		ModelAndView modelAndView = new ModelAndView("newEmployee");
		System.err.println(emp.getEmployeeId());
		System.err.println("Coming inside edit");
		RegisterBean bean = service.findObject(emp.getEmployeeId());
		modelAndView.addObject("registerBean", bean);
		return modelAndView;
	}

	@RequestMapping(value = "/showForm", params = "action=delete", method = RequestMethod.POST)
	public ModelAndView showFormDelete(@ModelAttribute("findEmp") @Valid FindEmployee emp) {
		ModelAndView modelAndView = new ModelAndView("newEmployee");
		modelAndView.addObject("registerBean", new RegisterBean());
		return modelAndView;
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("registerBean") @Valid RegisterBean bean, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("newEmployee");
		}
		service.save(bean);
		System.err.println(bean.toString());
		return new ModelAndView("EmployeeAddSuccess");
	}

	@RequestMapping("/saveAll")
	public String insert() {
		return service.saveAll();
	}
}
