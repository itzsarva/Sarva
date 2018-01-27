package com.sarva.custAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidation implements ConstraintValidator<Sarva, String> {

	@Override
	public void initialize(Sarva constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (value.equalsIgnoreCase("Sarva")) {
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}
