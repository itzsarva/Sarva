package com.sarva.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GenericExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ModelAndView catchException(Exception ex) {
		ModelAndView model = new ModelAndView("globalMethod");
		model.addObject("errorMessage", ex.getMessage());
		model.addObject("classs", ex.getClass());
		model.addObject("cause", ex.getCause());
		model.addObject("stackTrace", ex.getStackTrace().toString());
		model.addObject("exception", ex);
		return model;
	}

}
