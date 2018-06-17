package com.concretepage.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.concretepage.service.IUserInfoService;

@SessionAttributes("loginBean")
@Controller
@RequestMapping("/sess")
public class SessionController {

	@Autowired
	private IUserInfoService userInfoService;

	@ModelAttribute("loginBean")
	public String getUserName(Principal principal, Authentication authentication) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		System.err.println("Loading the login bean");
		System.err.println(userDetails.getUsername());
		System.err.println(principal.getName());
		return principal.getName();
	}

	@GetMapping("secure/article-details")
	public ModelAndView getAllUserArticles(@ModelAttribute("loginBean") String bean) {
		System.err.println("Coming here in the session controller");
		System.err.println(bean.toString());
		ModelAndView mav = new ModelAndView();
		mav.addObject("userArticles", userInfoService.getAllUserArticles());
		mav.setViewName("articles");
		return mav;
	}

}
