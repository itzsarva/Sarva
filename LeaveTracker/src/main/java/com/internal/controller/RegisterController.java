package com.internal.controller;

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

import com.internal.dto.RegisterBean;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	@Qualifier("passwordValidator")
	private Validator passwordValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.addValidators(passwordValidator);
	}

	@ModelAttribute("getRoles")
	public String[] getRoles() {
		String[] getRoles = { "Manager", "Senior System Engineer", "Team Lead" };
		return getRoles;
	}

	@ModelAttribute("referenceTeam")
	public String[] getReferenceTeam() {
		String[] referenceTeam = { "Xanite - Dev" };
		return referenceTeam;
	}

	@ModelAttribute("getVm")
	public String[] getvm() {
		String[] getVm = { "172.27.143.212", "172.27.143.213", "172.27.143.214" };
		return getVm;
	}

	@RequestMapping("/showForm")
	public ModelAndView showForm() {
		ModelAndView modelAndView = new ModelAndView("newEmployee");
		modelAndView.addObject("registerBean", new RegisterBean());
		return modelAndView;
	}

	@RequestMapping(value = "/showForm", params = "add")
	public ModelAndView showFormAdd() {
		ModelAndView modelAndView = new ModelAndView("newEmployee");
		modelAndView.addObject("registerBean", new RegisterBean());
		return modelAndView;
	}

	@RequestMapping(value = "/showForm", params = "edit")
	public ModelAndView showFormEdit() {
		ModelAndView modelAndView = new ModelAndView("newEmployee");
		modelAndView.addObject("registerBean", new RegisterBean());
		return modelAndView;
	}

	@RequestMapping(value = "/showForm", params = "delete")
	public ModelAndView showFormDelete() {
		ModelAndView modelAndView = new ModelAndView("newEmployee");
		modelAndView.addObject("registerBean", new RegisterBean());
		return modelAndView;
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("registerBean") @Valid RegisterBean bean, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("newEmployee");
		}
		System.err.println(bean.toString());
		return new ModelAndView("EmployeeAddSuccess");
	}
}
