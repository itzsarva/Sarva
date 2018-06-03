package com.internal.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.internal.dto.RegisterBean;

public class PasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// just validate the Register bean instances
		return RegisterBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegisterBean cust = (RegisterBean) target;
		if(!cust.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$")){
			errors.rejectValue("password", "notValid.password");
		}
		// check if password and confirm passwords match
		if (!(cust.getPassword().equals(cust.getConfirmPassword()))) {
			errors.rejectValue("password", "notmatch.password");
		}
	}

}