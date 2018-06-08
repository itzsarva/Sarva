package com.internal.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EquinitiEmailValidator implements ConstraintValidator<EquinitiEmail, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		/* After '@' equiniti.com must follow else it is an invalid email id */
		String[] email = null;
		if (null != value && !"".equalsIgnoreCase(value)) {
			email = value.split("@");
		}
		if (null != email && email[1].length() > 0) {
			if (email[1].equals("equiniti.com")) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

}
