package com.internal.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.internal.dto.LoginBean;

@Controller
@RequestMapping("/viewtimeSheet")
public class TimeSheetController {

	@PostMapping
	public ModelAndView getLoginPage(@ModelAttribute("loginBean") @Valid LoginBean bean, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("login");
		}
		return new ModelAndView("viewtimeSheet");
	}
}
