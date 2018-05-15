package com.sarva.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
@ResponseBody
public class FirstController {

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.err.println(request.getParameter("name"));

		RequestObj obj = new RequestObj("Some");

		otherMethod(obj);

		return "Successfully returned";
	}

	private void otherMethod(RequestObj obj) throws ServletException, IOException {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		request.setAttribute("newObject", obj);
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getResponse();
		request.getRequestDispatcher("http://localhost:8081/app2/get2").include(request, response);
		String success = (String) request.getAttribute("success");
		System.err.println(success);

	}

}
