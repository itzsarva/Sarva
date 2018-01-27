package com.sarva.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidation implements ConstraintValidator<NameValidator, String> {

	@Override
	public void initialize(NameValidator constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		System.err.println(value);
		if (value.equalsIgnoreCase("Sarva")) {
			return true;
		} else {
			return false;
		}
	}

}
