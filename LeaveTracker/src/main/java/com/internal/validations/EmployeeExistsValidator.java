package com.internal.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.internal.customAnnotations.EmployeeExists;
import com.internal.serviceImpl.RegisterServiceImpl;

@Component
public class EmployeeExistsValidator implements ConstraintValidator<EmployeeExists, Long> {

	@Autowired
	RegisterServiceImpl service;

	@Override
	public boolean isValid(Long employeeId, ConstraintValidatorContext arg1) {
		return service.findById(employeeId);
	}

}
