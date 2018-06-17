package com.concretepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("other")
public class OtherController {

	@PostMapping("/some")
	public String some(@ModelAttribute("loginBean") String bean) {
		bean.toString();
		return "login";
	}

}
