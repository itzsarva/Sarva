package com.internal.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EquinitiEmailValidator implements ConstraintValidator<EquinitiEmail, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		/* After '@' equiniti.com must follow else it is an invalid email id */
		String[] email = value.split("@");
		if (email[1].equals("equiniti.com")) {
			return true;
		} else {
			return false;
		}
	}

}
