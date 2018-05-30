package com.internal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController()
@RequestMapping("/test")
public class TestController {

	@RequestMapping(value = "/getJsp", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getJsp() {
		return new ModelAndView("newcustomer");
	}
	
	/*@RequestMapping(value = "/getJsp1", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getJsp1() {
		return new ModelAndView("jsvariable");
	}
*/
}
