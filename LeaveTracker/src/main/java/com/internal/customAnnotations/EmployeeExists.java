package com.internal.customAnnotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.internal.validations.EmployeeExistsValidator;

@Documented
@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = { EmployeeExistsValidator.class })
public @interface EmployeeExists {
	public String message() default "No Employee exists for the ID that you have mentioned";

	Class<?>[] groups() default {};

	public Class<? extends Payload>[] payload() default {};

}
