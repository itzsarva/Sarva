package com.internal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.internal.dto.LoginBean;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping
	public ModelAndView getLoginPage(@ModelAttribute("loginBean") LoginBean bean) {
		return new ModelAndView("login");
	}

}
