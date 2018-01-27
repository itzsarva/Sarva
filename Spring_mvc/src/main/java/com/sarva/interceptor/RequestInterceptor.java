package com.sarva.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RequestInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		String[] things = request.getParameterValues("things");
		for (String str : things) {
			System.err.println(str);
		}
		HttpSession session = request.getSession(true);
		session.setAttribute("some", "here is the some you have asked for");
		if (null != request.getParameter("name") && request.getParameter("name").equalsIgnoreCase("Sarva")) {
			System.err.println("Time when the request is processed  " + new Date());
			return true;
		} else {
			response.getWriter().print("you are not supposed to submit any , because you are not sarva.");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		modelAndView.addObject("sarva", "Sarva Has added something see what it is.");
		modelAndView.setViewName("successInt");
		System.err.println("before the view has been generated and time is " + new Date());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.err.println("After the view was genereated and the time is " + new Date());
	}

}
