package com.sarva.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Application2Controller {

	@RequestMapping("/get2")
	@ResponseBody
	public String get(HttpServletRequest request) {
		System.err.println(request.getAttribute("newObject"));
		request.setAttribute("success", "success");
		return "Success";
	}

}
