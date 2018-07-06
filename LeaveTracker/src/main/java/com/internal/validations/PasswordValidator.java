package com.internal.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.internal.dto.RegisterBean;

@Component
public class PasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// just validate the Register bean instances
		return RegisterBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegisterBean cust = (RegisterBean) target;
		if (null != cust.getPassword()) {
			// maximum length 8 , 1 alphabet , 1 digit and 1 special character
			if (!cust.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$")) {
				errors.rejectValue("password", "notValid.password",
						"The password you have entered does not match our complexity, Please ensure you have 1 Alphabet , 1 digit and 1 special character.");
			}
		}
	}
}